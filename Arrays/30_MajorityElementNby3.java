// Problem: Find all elements that appear more than N/3 times in the array

// Brute Force Approach:
// - For each element, count its frequency by scanning the array
// - If frequency > N/3, add to result (avoid duplicates)
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach:
// - Use a HashMap to store frequencies
// - Collect elements with frequency > N/3
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Optimal Approach (Boyer-Moore Voting Algorithm):
// - At most 2 elements can appear more than N/3 times
// - Use modified Boyer-Moore to find candidates
// - Verify counts in second pass
// - Time Complexity: O(n)
// - Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public List<Integer> brute(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) count++;
            }
            if (count > n / 3 && !result.contains(nums[i])) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    // Better
    public List<Integer> better(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int key : freq.keySet()) {
            if (freq.get(key) > n / 3) {
                result.add(key);
            }
        }
        return result;
    }

    // Optimal (Boyer-Moore Voting Algorithm)
    public List<Integer> optimal(int[] nums) {
        int n = nums.length;
        int cand1 = 0, cand2 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == cand1) count1++;
            else if (num == cand2) count2++;
            else if (count1 == 0) { cand1 = num; count1 = 1; }
            else if (count2 == 0) { cand2 = num; count2 = 1; }
            else { count1--; count2--; }
        }

        // Verify candidates
        count1 = 0; count2 = 0;
        for (int num : nums) {
            if (num == cand1) count1++;
            else if (num == cand2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(cand1);
        if (count2 > n / 3) result.add(cand2);

        return result;
    }

    // Demo main
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 1, 1, 3, 2};
        int[] nums2 = {1, 2, 1, 1, 3, 2, 2};

        System.out.println("Brute: " + sol.brute(nums1));
        System.out.println("Better: " + sol.better(nums1));
        System.out.println("Optimal: " + sol.optimal(nums1));

        System.out.println("Brute: " + sol.brute(nums2));
        System.out.println("Better: " + sol.better(nums2));
        System.out.println("Optimal: " + sol.optimal(nums2));
    }
}
