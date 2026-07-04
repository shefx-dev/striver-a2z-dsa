// Problem: Length of the Longest Subarray with Zero Sum

// Brute Force Approach:
// - Generate all possible subarrays and calculate their sum
// - If sum == 0, update max length
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach (Prefix Sum + HashMap):
// - Maintain prefix sums and store them in a hashmap
// - If the same prefix sum appears again, the subarray between those indices has sum = 0
// - Update max length accordingly
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Optimal Approach:
// - Same as Better (Prefix Sum + HashMap) because negatives are allowed
// - Sliding window does not work here since array has negatives
// - Time Complexity: O(n)
// - Space Complexity: O(n)

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // Better (Prefix Sum + HashMap)
    public int better(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                maxLen = i + 1;
            }
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    // Optimal (Same as Better)
    public int optimal(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0) {
                maxLen = i + 1;
            }
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
