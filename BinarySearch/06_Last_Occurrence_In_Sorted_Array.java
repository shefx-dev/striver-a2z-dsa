// Problem: Last Occurrence in Sorted Array

// Brute Force Approach:
// - Traverse the array linearly from start to end
// - Track the last index where target appears
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Better Approach:
// - Use built-in Arrays.binarySearch() to find any occurrence
// - If found, move forward until the last occurrence
// - Time Complexity: O(log n + k) where k is number of duplicates
// - Space Complexity: O(1)

// Optimal Approach:
// - Implement modified binary search manually
// - When target is found, move search to the right half to ensure last occurrence
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

import java.util.Arrays;

class Solution {

    // Brute Force
    public int brute(int[] nums, int target) {
        int lastIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) lastIndex = i;
        }
        return lastIndex;
    }

    // Better
    public int better(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);
        if (idx < 0) return -1;
        while (idx + 1 < nums.length && nums[idx + 1] == target) {
            idx++;
        }
        return idx;
    }

    // Optimal
    public int optimal(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                result = mid;       // record occurrence
                low = mid + 1;      // move right to find last occurrence
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
