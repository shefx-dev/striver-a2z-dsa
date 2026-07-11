// Problem: Search Insert Position

// Brute Force Approach:
// - Traverse array until you find first element >= target
// - Return that index or nums.length if target is larger
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Better Approach:
// - Use Arrays.binarySearch() and adjust insertion point
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

// Optimal Approach:
// - Manual binary search
// - If found, return index
// - If not found, return low (insertion position)
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

import java.util.Arrays;

class Solution {

    // Brute Force
    public int bruteInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

    // Better
    public int betterInsert(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);
        if (idx >= 0) return idx;
        return -(idx + 1);
    }

    // Optimal
    public int optimalInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
