// Problem: Search X in Sorted Array

// Brute Force Approach:
// - Traverse the array linearly and check each element
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Better Approach:
// - Use built-in Arrays.binarySearch()
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

// Optimal Approach:
// - Implement binary search manually
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

import java.util.Arrays;

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
        return Arrays.binarySearch(nums, target);
    }

    // Optimal
    public int optimal(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
