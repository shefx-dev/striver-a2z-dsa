// Problem: Next Permutation
// Given an array of integers, rearrange them into the lexicographically next greater permutation.
// If not possible (array is in descending order), rearrange to the lowest possible order (ascending).

// Brute Force Approach:
// - Generate all permutations of the array.
// - Sort them lexicographically.
// - Find the current permutation and return the next one.
// - Time Complexity: O(n! * n log n) (impractical)
// - Space Complexity: O(n!)

// Better Approach:
// - Sort the array.
// - Use built-in next_permutation logic (like C++ STL) or simulate by checking next lexicographic order.
// - Still not efficient for interviews.
// - Time Complexity: O(n log n)
// - Space Complexity: O(1)

// Optimal Approach:
// - Traverse from right to left to find the first decreasing element (pivot).
// - Find the element just larger than pivot and swap.
// - Reverse the suffix after pivot.
// - Time Complexity: O(n)
// - Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public int[] brute(int[] nums) {
        List<int[]> permutations = new ArrayList<>();
        permute(nums, 0, permutations);

        // Sort lexicographically
        permutations.sort((a, b) -> {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) return a[i] - b[i];
            }
            return 0;
        });

        // Find current permutation
        for (int i = 0; i < permutations.size(); i++) {
            if (Arrays.equals(permutations.get(i), nums)) {
                return i + 1 < permutations.size() ? permutations.get(i + 1) : permutations.get(0);
            }
        }
        return nums;
    }

    private void permute(int[] nums, int start, List<int[]> result) {
        if (start == nums.length) {
            result.add(nums.clone());
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permute(nums, start + 1, result);
            swap(nums, start, i);
        }
    }

    // Better
    public int[] better(int[] nums) {
        Arrays.sort(nums);
        return nums; // just returns sorted (lowest order) — not truly useful in interviews
    }

    // Optimal
    public void optimal(int[] nums) {
        int n = nums.length;
        int index = -1;

        // Step 1: Find pivot (first decreasing element from right)
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break; // important to break here
            }
        }

        if (index == -1) {
            // Entire array is descending → reverse to smallest permutation
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 2: Find element just larger than pivot
        for (int i = n - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, index, i);
                break;
            }
        }

        // Step 3: Reverse suffix
        reverse(nums, index + 1, n - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1,3,2};
        sol.optimal(arr1);
        System.out.println("Optimal: " + Arrays.toString(arr1)); // [2,1,3]

        int[] arr2 = {3,2,1};
        sol.optimal(arr2);
        System.out.println("Optimal: " + Arrays.toString(arr2)); // [1,2,3]
    }
}
