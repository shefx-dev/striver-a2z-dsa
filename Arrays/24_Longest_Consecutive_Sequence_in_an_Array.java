// Problem: Longest Consecutive Sequence in an Array
// Given an array of integers, return the length of the longest sequence of consecutive integers.
// The sequence can appear in any order.

// Brute Force Approach:
// - For each element, check if the next consecutive element exists by scanning the array.
// - Keep counting until the sequence breaks.
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach:
// - Sort the array.
// - Traverse linearly, counting consecutive streaks (skip duplicates).
// - Keep track of the maximum streak length.
// - Time Complexity: O(n log n)
// - Space Complexity: O(1)

// Optimal Approach:
// - Use a HashSet for O(1) lookups.
// - For each number, check if it's the start of a sequence (num-1 not in set).
// - Count forward until the sequence ends.
// - Track the longest streak.
// - Time Complexity: O(n)
// - Space Complexity: O(n)

import java.util.*;

class Solution {

    // Brute Force
    public int brute(int[] nums) {
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int length = 1;
            while (contains(nums, current + 1)) {
                current++;
                length++;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }

    private boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }

    // Better
    public int better(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue; // skip duplicates
            if (nums[i] == nums[i - 1] + 1) {
                currentStreak++;
            } else {
                longest = Math.max(longest, currentStreak);
                currentStreak = 1;
            }
        }
        return Math.max(longest, currentStreak);
    }

    // Optimal
    public int optimal(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) { // start of sequence
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longest = Math.max(longest, currentStreak);
            }
        }
        return longest;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {100, 4, 200, 1, 3, 2};
        int[] arr2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println("Brute: " + sol.brute(arr1));   // 4
        System.out.println("Better: " + sol.better(arr1)); // 4
        System.out.println("Optimal: " + sol.optimal(arr1)); // 4

        System.out.println("Brute: " + sol.brute(arr2));   // 9
        System.out.println("Better: " + sol.better(arr2)); // 9
        System.out.println("Optimal: " + sol.optimal(arr2)); // 9
    }
}
