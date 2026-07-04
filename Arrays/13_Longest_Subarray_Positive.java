// Problem: Longest Subarray with given Sum K (Positives)

// Brute Force Approach:
// - Try all possible subarrays and calculate their sum
// - If sum == k, update max length
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach (Prefix Sum + HashMap):
// - Maintain prefix sums and store them in a hashmap
// - If (prefixSum - k) exists, update max length
// - Works for positives + negatives, but here still valid
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Optimal Approach (Sliding Window for Positives):
// - Use two pointers (left, right) and maintain a running sum
// - Expand right until sum >= k, shrink left if sum > k
// - If sum == k, update max length
// - Time Complexity: O(n)
// - Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // Better (Prefix Sum + HashMap)
    public int better(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) maxLen = i + 1;
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    // Optimal (Sliding Window for Positives)
    public int optimal(int[] nums, int k) {
        int left = 0, sum = 0, maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left++];
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
}
