// Problem: Largest Element in Array

// Brute Force Approach:
// - Sort the array and return the last element
// - Time Complexity: O(n log n)
// - Space Complexity: O(1)

// Better Approach:
// - Traverse the array and keep track of max element
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Optimal Approach:
// - Same as Better (single traversal)
// - Time Complexity: O(n)
// - Space Complexity: O(1)

import java.util.Arrays;

class Solution {

    // Brute Force
    public int brute(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1];
    }

    // Better
    public int better(int[] nums) {
        int largestElement = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largestElement) {
                largestElement = nums[i];
            }
        }
        return largestElement;
    }

    // Optimal (same as Better)
    public int optimal(int[] nums) {
        int largestElement = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largestElement) {
                largestElement = nums[i];
            }
        }
        return largestElement;
    }
}
