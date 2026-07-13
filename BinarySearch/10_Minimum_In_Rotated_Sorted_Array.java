// Problem: Minimum in Rotated Sorted Array (distinct values)

// Brute Force Approach:
// - Traverse the entire array and find the minimum element
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Better Approach:
// - Use linear scan but stop early when sorted portion is detected
// - Still O(n) in worst case
// - Space Complexity: O(1)

// Optimal Approach:
// - Use modified binary search
// - If arr[mid] <= arr[high], right half is sorted → minimum lies in left half (including mid)
// - Else, left half is sorted → minimum lies in right half
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

public class Solution {

    // -------------------------
    // Brute Force
    // -------------------------
    public int brute(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
        }
        return min;
    }

    // -------------------------
    // Better Approach
    // -------------------------
    public int better(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // If sorted portion detected, arr[i] is minimum
            if (arr[i] < arr[i - 1]) {
                return arr[i];
            }
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    // -------------------------
    // Optimal Approach (Binary Search)
    // -------------------------
    public int optimal(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If right half is sorted, minimum is in left half (including mid)
            if (arr[mid] < arr[high]) {
                high = mid;
            }
            // Left half is sorted, minimum is in right half
            else {
                low = mid + 1;
            }
        }

        return arr[low]; // low == high → minimum element
    }

    // -------------------------
    // Main (Optional for testing)
    // -------------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {4, 5, 6, 7, 0, 1, 2, 3};
        int[] arr2 = {3, 4, 5, 1, 2};

        System.out.println(sol.brute(arr1));   // 0
        System.out.println(sol.better(arr1));  // 0
        System.out.println(sol.optimal(arr1)); // 0

        System.out.println(sol.brute(arr2));   // 1
        System.out.println(sol.better(arr2));  // 1
        System.out.println(sol.optimal(arr2)); // 1
    }
}
