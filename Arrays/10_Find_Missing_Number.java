// Problem: Find Missing Number

// Brute Force Approach:
// - For each number from 0 to n, check if it exists in the array
// - Return the number that is not found
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach (Hashing):
// - Use a boolean array or HashSet to mark presence of each number
// - Traverse from 0 to n and return the missing one
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Optimal Approach (Math / XOR):
// - Use sum formula or XOR to find the missing number
// - Sum formula: missing = (n*(n+1))/2 - sum(nums)
// - XOR formula: XOR all numbers from 0..n and XOR with all elements in nums
// - Time Complexity: O(n)
// - Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            boolean found = false;
            for (int num : nums) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) return i;
        }
        return -1; // should never happen
    }

    // Better (Hashing)
    public int better(int[] nums) {
        int n = nums.length;
        boolean[] present = new boolean[n+1];
        for (int num : nums) {
            present[num] = true;
        }
        for (int i = 0; i <= n; i++) {
            if (!present[i]) return i;
        }
        return -1;
    }

    // Optimal (Sum Formula)
    public int optimalSum(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }

    // Optimal (XOR Formula)
    public int optimalXor(int[] nums) {
        int n = nums.length;
        int xorAll = 0;
        for (int i = 0; i <= n; i++) xorAll ^= i;
        int xorNums = 0;
        for (int num : nums) xorNums ^= num;
        return xorAll ^ xorNums;
    }

    // Test main
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {0, 2, 3, 1, 4};
        int[] nums2 = {0, 1, 2, 4, 5, 6};

        System.out.println("Brute (nums1):   " + sol.brute(nums1));
        System.out.println("Better (nums1):  " + sol.better(nums1));
        System.out.println("OptimalSum (nums1): " + sol.optimalSum(nums1));
        System.out.println("OptimalXor (nums1): " + sol.optimalXor(nums1));

        System.out.println("Brute (nums2):   " + sol.brute(nums2));
        System.out.println("Better (nums2):  " + sol.better(nums2));
        System.out.println("OptimalSum (nums2): " + sol.optimalSum(nums2));
        System.out.println("OptimalXor (nums2): " + sol.optimalXor(nums2));
    }
}
