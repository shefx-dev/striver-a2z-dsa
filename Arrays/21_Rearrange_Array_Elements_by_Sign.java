// Problem: Rearrange Array Elements by Sign
// Given an array with equal number of positive and negative elements,
// rearrange it so that positives and negatives alternate,
// while preserving their relative order.

// Brute Force Approach:
// - Separate positives and negatives into two lists.
// - Build the result array by alternately picking from each list.
// - Time Complexity: O(n)
// - Space Complexity: O(n)


// Better Approach:
// - Use two arrays for positives and negatives.
// - Traverse once to fill them, then merge alternately.
// - Time Complexity: O(n)
// - Space Complexity: O(n)


// Optimal Approach:
// - Traverse once and directly place positives at even indices,
//   negatives at odd indices in the result array.
// - Preserves relative order automatically.
// - Time Complexity: O(n)
// - Space Complexity: O(n)

import java.util.*;

class Solution {

    // Brute Force
    public int[] brute(int[] nums) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        
        for (int num : nums) {
            if (num > 0) positives.add(num);
            else negatives.add(num);
        }
        
        int[] result = new int[nums.length];
        int posIndex = 0, negIndex = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = positives.get(posIndex++);
            } else {
                result[i] = negatives.get(negIndex++);
            }
        }
        return result;
    }

    // Better
    public int[] better(int[] nums) {
        int n = nums.length;
        int[] positives = new int[n/2];
        int[] negatives = new int[n/2];
        
        int p = 0, q = 0;
        for (int num : nums) {
            if (num > 0) positives[p++] = num;
            else negatives[q++] = num;
        }
        
        int[] result = new int[n];
        p = 0; q = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) result[i] = positives[p++];
            else result[i] = negatives[q++];
        }
        return result;
    }

    // Optimal
    public int[] optimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int posIndex = 0; // even positions
        int negIndex = 1; // odd positions
        
        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }
        return result;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {1,2,-4,-5};
        int[] arr2 = {1,2,-3,-1,-2,-3};

        System.out.println("Brute: " + Arrays.toString(sol.brute(arr1)));
        System.out.println("Better: " + Arrays.toString(sol.better(arr1)));
        System.out.println("Optimal: " + Arrays.toString(sol.optimal(arr1)));

        System.out.println("Brute: " + Arrays.toString(sol.brute(arr2)));
        System.out.println("Better: " + Arrays.toString(sol.better(arr2)));
        System.out.println("Optimal: " + Arrays.toString(sol.optimal(arr2)));
    }
}
