// Problem: Find how many times the array has been rotated (distinct values)

// Brute Force Approach:
// - The minimum element is the rotation point
// - Traverse the array and find the minimum element's index
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Better Approach:
// - Scan linearly but stop early when rotation break is found
// - Still O(n) worst case
// - Space Complexity: O(1)

// Optimal Approach:
// - Use binary search to find the minimum element (pivot index)
// - Rotation count = pivot index
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

public class Solution {

    // -------------------------
    // Brute Force
    // -------------------------
    public int brute(int[] arr) {
        int min = arr[0];
        int index = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }

        return index; // rotation count
    }

    // -------------------------
    // Better Approach
    // -------------------------
    public int better(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // Rotation break found
            if (arr[i] < arr[i - 1]) {
                return i; // pivot index = rotation count
            }
        }
        return 0; // array not rotated
    }

    // -------------------------
    // Optimal Approach (Binary Search)
    // -------------------------
    public int optimal(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Right half is sorted → minimum in left half (including mid)
            if (arr[mid] < arr[high]) {
                high = mid;
            }
            // Left half sorted → minimum in right half
            else {
                low = mid + 1;
            }
        }

        return low; // pivot index = rotation count
    }

    // -------------------------
    // Main (Optional for testing)
    // -------------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {4, 5, 6, 7, 0, 1, 2, 3};
        int[] arr2 = {3, 4, 5, 1, 2};

        System.out.println(sol.brute(arr1));   // 4
        System.out.println(sol.better(arr1));  // 4
        System.out.println(sol.optimal(arr1)); // 4

        System.out.println(sol.brute(arr2));   // 3
        System.out.println(sol.better(arr2));  // 3
        System.out.println(sol.optimal(arr2)); // 3
    }
}
