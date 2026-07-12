// Problem: Floor and Ceil in Sorted Array

// Brute Force Approach:
// - Traverse the array linearly
// - Track the largest element <= x (floor) and smallest element >= x (ceil)
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Better Approach:
// - Use built-in Arrays.binarySearch() to locate x or insertion point
// - If found, floor = ceil = x
// - If not found, use insertion point to determine floor and ceil
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

// Optimal Approach:
// - Implement binary search manually
// - While searching, keep track of potential floor and ceil
// - Floor updates when nums[mid] <= x
// - Ceil updates when nums[mid] >= x
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

import java.util.Arrays;

class Solution {

    // Brute Force
    public int[] brute(int[] nums, int x) {
        int floor = -1, ceil = -1;
        for (int num : nums) {
            if (num <= x) floor = num;
            if (num >= x && ceil == -1) ceil = num;
        }
        return new int[]{floor, ceil};
    }

    // Better
    public int[] better(int[] nums, int x) {
        int idx = Arrays.binarySearch(nums, x);
        if (idx >= 0) {
            return new int[]{nums[idx], nums[idx]}; // exact match
        } else {
            int insertionPoint = -idx - 1;
            int floor = (insertionPoint - 1 >= 0) ? nums[insertionPoint - 1] : -1;
            int ceil = (insertionPoint < nums.length) ? nums[insertionPoint] : -1;
            return new int[]{floor, ceil};
        }
    }

    // Optimal
    public int[] optimal(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        int floor = -1, ceil = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == x) {
                return new int[]{nums[mid], nums[mid]};
            } else if (nums[mid] < x) {
                floor = nums[mid];
                low = mid + 1;
            } else {
                ceil = nums[mid];
                high = mid - 1;
            }
        }
        return new int[]{floor, ceil};
    }
}
