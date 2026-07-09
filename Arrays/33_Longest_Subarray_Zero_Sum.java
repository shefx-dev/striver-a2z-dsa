// Problem: Length of the Longest Subarray with Zero Sum

// Brute Force Approach:
// - For every pair (i, j), compute the sum of subarray [i..j] from scratch
// - If sum == 0, update the max length
// - Time Complexity: O(n^3)
// - Space Complexity: O(1)

// Better Approach (Prefix Sum Array + Nested Loop):
// - Precompute prefix sums so subarray sum [i..j] = prefix[j] - prefix[i-1]
// - Use nested loops to check all pairs using the prefix sum array (avoids recomputation)
// - Time Complexity: O(n^2)
// - Space Complexity: O(n)

// Optimal Approach (Prefix Sum + HashMap):
// - Maintain a running prefix sum while traversing the array
// - If prefix sum == 0 at index i, the subarray [0..i] has sum zero -> length = i+1
// - If the same prefix sum has occurred before at index j, then subarray (j+1..i) has sum zero -> length = i-j
// - Store the FIRST occurrence of each prefix sum in a HashMap to maximize length
// - Time Complexity: O(n)
// - Space Complexity: O(n)

import java.util.*;

class Solution {
    // Brute Force
    public int brute(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // Better (Prefix Sum Array + Nested Loop)
    public int better(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // sum of subarray [i..j] = prefix[j] - prefix[i-1] (prefix[-1] treated as 0)
                int sum = prefix[j] - (i > 0 ? prefix[i - 1] : 0);
                if (sum == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // Optimal (Prefix Sum + HashMap)
    public int optimal(int[] nums) {
        Map<Integer, Integer> firstIndex = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum == 0) {
                maxLen = i + 1;
            } else if (firstIndex.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - firstIndex.get(sum));
            } else {
                firstIndex.put(sum, i);
            }
        }
        return maxLen;
    }

    // Test main
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {9, -3, 3, -1, 6, -5};
        int[] nums2 = {6, -2, 2, -8, 1, 7, 4, -10};

        System.out.println("Brute (nums1):   " + sol.brute(nums1));
        System.out.println("Better (nums1):  " + sol.better(nums1));
        System.out.println("Optimal (nums1): " + sol.optimal(nums1));

        System.out.println("Brute (nums2):   " + sol.brute(nums2));
        System.out.println("Better (nums2):  " + sol.better(nums2));
        System.out.println("Optimal (nums2): " + sol.optimal(nums2));
    }
}
