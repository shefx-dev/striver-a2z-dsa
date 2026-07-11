// Problem: Lower Bound (first index where nums[i] >= target)

// Brute Force Approach:
// - Traverse array until you find first element >= target
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Better Approach:
// - Use Arrays.binarySearch() and adjust insertion point
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

// Optimal Approach:
// - Manual binary search tracking candidate answer
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

import java.util.Arrays;

class Solution {

    // Brute Force
    public int bruteLowerBound(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

    // Better
    public int betterLowerBound(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);
        if (idx >= 0) return idx;
        return -(idx + 1); // insertion point
    }

    // Optimal
    public int optimalLowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1, ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
