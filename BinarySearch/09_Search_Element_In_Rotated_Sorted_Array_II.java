// Problem: Search Element in Rotated Sorted Array II (with duplicates)

// Brute Force Approach:
// - Traverse the array linearly and check each element
// - Return true if found, else false
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Better Approach:
// - Try to find pivot using modified binary search (but duplicates may degrade performance)
// - Perform binary search in two halves
// - Time Complexity: O(n) worst case (due to duplicates)
// - Space Complexity: O(1)

// Optimal Approach:
// - Modified binary search that handles duplicates
// - If arr[low] == arr[mid] == arr[high], shrink boundaries
// - Otherwise, determine sorted half and move accordingly
// - Time Complexity: O(log n) average, O(n) worst case
// - Space Complexity: O(1)

public class Solution {

    // -------------------------
    // Brute Force
    // -------------------------
    public boolean brute(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }

    // -------------------------
    // Better Approach
    // -------------------------
    public boolean better(int[] arr, int target) {
        int pivot = findPivot(arr);

        // Search in left half
        if (binarySearch(arr, 0, pivot - 1, target)) return true;

        // Search in right half
        return binarySearch(arr, pivot, arr.length - 1, target);
    }

    private int findPivot(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else if (arr[mid] < arr[high]) {
                high = mid;
            } else {
                // duplicates → shrink
                high--;
            }
        }
        return low; // index of smallest element
    }

    private boolean binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return true;
            else if (arr[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    // -------------------------
    // Optimal Approach
    // -------------------------
    public boolean optimal(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) return true;

            // Case 1: duplicates block decision
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low++;
                high--;
                continue;
            }

            // Case 2: Left half sorted
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // Case 3: Right half sorted
            else {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    // -------------------------
    // Main (Optional for testing)
    // -------------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int target = 3;

        System.out.println(sol.brute(arr, target));   // true
        System.out.println(sol.better(arr, target));  // true
        System.out.println(sol.optimal(arr, target)); // true
    }
}
