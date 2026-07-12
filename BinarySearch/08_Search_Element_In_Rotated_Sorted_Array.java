// Problem: Search Element in a Rotated Sorted Array

// Brute Force Approach:
// - Traverse the array linearly and check each element
// - Return index if found, else -1
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Better Approach:
// - Find the pivot (index of smallest element) using binary search
// - Perform binary search in the two sorted halves separately
// - Time Complexity: O(log n) for pivot + O(log n) for search = O(log n)
// - Space Complexity: O(1)

// Optimal Approach:
// - Modify binary search directly
// - At each step, check which half (left or right) is sorted
// - Decide whether to move left or right based on target’s range
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public int brute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    // Better
    public int better(int[] nums, int target) {
        int pivot = findPivot(nums);
        // Search in left half
        int left = binarySearch(nums, 0, pivot - 1, target);
        if (left != -1) return left;
        // Search in right half
        return binarySearch(nums, pivot, nums.length - 1, target);
    }

    private int findPivot(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low; // index of smallest element
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    // Optimal
    public int optimal(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;

            // Left half sorted
            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half sorted
            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
