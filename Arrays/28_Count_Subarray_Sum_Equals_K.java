// Problem: Count Subarray Sum Equals K
// Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.

// Brute Force Approach:
// - Generate all possible subarrays using two loops.
// - For each subarray, calculate the sum and check if it equals k.
// - Time Complexity: O(n^3) (two loops + sum calculation)
// - Space Complexity: O(1)

// Better Approach:
// - Use two loops, but maintain a running sum instead of recalculating each time.
// - For each starting index, extend the subarray and update sum incrementally.
// - Count when sum == k.
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Optimal Approach:
// - Use a HashMap to store prefix sums and their frequencies.
// - For each element, calculate current prefix sum.
// - Check if (prefixSum - k) exists in the map → that means a subarray ending here has sum k.
// - Add frequency to count.
// - Time Complexity: O(n)
// - Space Complexity: O(n)

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int p = i; p <= j; p++) {
                    sum += nums[p];
                }
                if (sum == k) count++;
            }
        }
        return count;
    }

    // Better
    public int better(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }

    // Optimal
    public int optimal(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // Initialize with prefix sum 0
        map.put(0, 1);

        for (int num : nums) {
            prefixSum += num;

            // Check if prefixSum - k exists
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Update frequency of prefixSum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
