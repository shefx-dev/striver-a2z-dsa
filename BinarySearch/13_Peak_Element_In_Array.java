// Problem: Peak Element in Array
// A peak element is one that is strictly greater than both neighbors.
// If multiple peaks exist, return the index of any one peak.

// Brute Force Approach:
// - Check every element arr[i] (except edges)
// - If arr[i] > arr[i-1] AND arr[i] > arr[i+1], return i
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Better Approach:
// - Use a simple linear scan with boundary checks
// - Check edges separately because they can also be peaks
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Optimal Approach (Binary Search):
// - If mid element is less than its right neighbor → peak lies on the right
// - Else → peak lies on the left
// - This works because the array always has at least one peak
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

public class Solution {

    // -------------------------
    // Brute Force
    // -------------------------
    public int brute(int[] arr) {
        int n = arr.length;

        // Check middle elements
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }

        // Check edges
        if (n > 1 && arr[0] > arr[1]) return 0;
        if (n > 1 && arr[n - 1] > arr[n - 2]) return n - 1;

        return -1; // no peak found (rare case)
    }

    // -------------------------
    // Better Approach (Linear Scan)
    // -------------------------
    public int better(int[] arr) {
        int n = arr.length;

        // Check first element
        if (n == 1 || arr[0] > arr[1]) return 0;

        // Check middle elements
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }

        // Check last element
        if (arr[n - 1] > arr[n - 2]) return n - 1;

        return -1;
    }

    // -------------------------
    // Optimal Approach (Binary Search)
    // -------------------------
    public int optimal(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid < mid+1 → peak is on the right
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } 
            // Else → peak is on the left (including mid)
            else {
                high = mid;
            }
        }

        return low; // low == high → peak index
    }

    // -------------------------
    // Main (Optional for testing)
    // -------------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1,2,3,4,5,6,7,8,5,1};
        int[] arr2 = {1,2,1,3,5,6,4};

        System.out.println(sol.brute(arr1));   // 7
        System.out.println(sol.better(arr1));  // 7
        System.out.println(sol.optimal(arr1)); // 7

        System.out.println(sol.brute(arr2));   // 1 or 5
        System.out.println(sol.better(arr2));  // 1 or 5
        System.out.println(sol.optimal(arr2)); // 1 or 5
    }
}
