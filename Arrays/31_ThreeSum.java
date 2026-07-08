// Problem: Find all unique triplets in the array that sum to zero

// Brute Force Approach:
// - Use three nested loops to check all triplets
// - If sum == 0, add triplet to result (avoid duplicates)
// - Time Complexity: O(n^3)
// - Space Complexity: O(n)

// Better Approach:
// - Fix one element, use HashSet to check if complement exists
// - Store triplets in a set to avoid duplicates
// - Time Complexity: O(n^2)
// - Space Complexity: O(n)

// Optimal Approach (Sorting + Two Pointers):
// - Sort the array
// - Fix one element, use two pointers to find pairs that sum to -nums[i]
// - Skip duplicates smartly
// - Time Complexity: O(n^2)
// - Space Complexity: O(1) (excluding output)

import java.util.*;

class Solution {

    // Brute Force
    public List<List<Integer>> brute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        if (!result.contains(triplet)) {
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        return result;
    }

    // Better
    public List<List<Integer>> better(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int complement = -(nums[i] + nums[j]);
                if (seen.contains(complement)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(triplet);
                    set.add(triplet);
                }
                seen.add(nums[j]);
            }
        }
        return new ArrayList<>(set);
    }

    // Optimal
    public List<List<Integer>> optimal(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++; right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    // Demo main
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[] nums2 = {-1, 0, 1, 0};

        System.out.println("Brute: " + sol.brute(nums1));
        System.out.println("Better: " + sol.better(nums1));
        System.out.println("Optimal: " + sol.optimal(nums1));

        System.out.println("Brute: " + sol.brute(nums2));
        System.out.println("Better: " + sol.better(nums2));
        System.out.println("Optimal: " + sol.optimal(nums2));
    }
}
