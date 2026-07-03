// Problem: Maximum Consecutive Ones

// Brute Force Approach:
// - For each index, if nums[i] == 1, count consecutive 1s starting from i
// - Keep track of the maximum count
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach:
// - Traverse the array once
// - Maintain a current count of consecutive 1s, reset when encountering 0
// - Track the maximum count seen so far
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Optimal Approach (same as Better):
// - Single traversal with two variables (current streak, max streak)
// - Time Complexity: O(n)
// - Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] nums) {
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1) {
                    count++;
                } else {
                    break;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    // Better
    public int better(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }
        return maxCount;
    }

    // Optimal (same as Better)
    public int optimal(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else {
                currentCount = 0;
            }
        }
        return maxCount;
    }

    // Test main
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 1, 0, 0, 1, 1, 1, 0};
        int[] nums2 = {0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println("Brute (nums1):   " + sol.brute(nums1));
        System.out.println("Better (nums1):  " + sol.better(nums1));
        System.out.println("Optimal (nums1): " + sol.optimal(nums1));

        System.out.println("Brute (nums2):   " + sol.brute(nums2));
        System.out.println("Better (nums2):  " + sol.better(nums2));
        System.out.println("Optimal (nums2): " + sol.optimal(nums2));
    }
}
