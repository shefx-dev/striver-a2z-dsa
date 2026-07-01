// Problem: Check if the Array is Sorted (Non-decreasing Order)

// Brute Force Approach:
// - Compare every pair (i, j) where j > i
// - If any nums[i] > nums[j], array is not sorted
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach:
// - Compare only adjacent elements
// - If any nums[i] > nums[i+1], array is not sorted
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Optimal Approach:
// - Same as Better but cleaner implementation
// - Compare nums[i] with nums[i-1]
// - Time Complexity: O(n)
// - Space Complexity: O(1)

import java.util.ArrayList;

class Solution {

    // Brute Force
    public boolean brute(ArrayList<Integer> nums) {
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) > nums.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Better
    public boolean better(ArrayList<Integer> nums) {
        int n = nums.size();

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // Optimal (Cleaner Version)
    public boolean optimal(ArrayList<Integer> nums) {
        int n = nums.size();

        for (int i = 1; i < n; i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
