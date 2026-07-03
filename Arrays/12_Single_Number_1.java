// Problem: Single Number I

// Brute Force Approach:
// - For each element, count how many times it appears in the array
// - Return the element that appears only once
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach (HashMap / HashSet):
// - Use a HashMap to count frequencies OR a HashSet to track duplicates
// - Return the element with frequency 1
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Optimal Approach (XOR):
// - XOR all elements together
// - Since x ^ x = 0 and x ^ 0 = x, all pairs cancel out
// - The leftover is the single number
// - Time Complexity: O(n)
// - Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) count++;
            }
            if (count == 1) return nums[i];
        }
        return -1; // should never happen
    }

    // Better (HashMap)
    public int better(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }

    // Better (HashSet alternative)
    public int betterSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sumSet = 0, sumArray = 0;
        for (int num : nums) {
            set.add(num);
            sumArray += num;
        }
        for (int num : set) sumSet += num;
        // Formula: 2 * sumSet - sumArray = single number
        return 2 * sumSet - sumArray;
    }

    // Optimal (XOR)
    public int optimal(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;
        return xor;
    }

    // Test main
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 2, 2, 4, 3, 1, 4};
        int[] nums2 = {5};

        System.out.println("Brute (nums1):   " + sol.brute(nums1));
        System.out.println("BetterMap (nums1): " + sol.better(nums1));
        System.out.println("BetterSet (nums1): " + sol.betterSet(nums1));
        System.out.println("OptimalXOR (nums1): " + sol.optimal(nums1));

        System.out.println("Brute (nums2):   " + sol.brute(nums2));
        System.out.println("BetterMap (nums2): " + sol.better(nums2));
        System.out.println("BetterSet (nums2): " + sol.betterSet(nums2));
        System.out.println("OptimalXOR (nums2): " + sol.optimal(nums2));
    }
}
