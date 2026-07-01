// Problem: Find Second Largest Element in an Array

// Approaches:
// Brute Force: Sorting
// Better: Two Pass
// Optimal: Single Pass

import java.util.Arrays;

class Solution {

    // Brute Force
    // Time: O(n log n)
    // Space: O(1)
    public int brute(int[] nums) {
        if (nums.length < 2) return -1;

        Arrays.sort(nums);
        int n = nums.length;

        int largest = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] != largest) {
                return nums[i];
            }
        }
        return -1; // no second largest
    }

    // Better (Two Pass)
    // Time: O(n)
    // Space: O(1)
    public int better(int[] nums) {
        if (nums.length < 2) return -1;

        int largest = Integer.MIN_VALUE;

        // First pass → find largest
        for (int num : nums) {
            if (num > largest) {
                largest = num;
            }
        }

        // Second pass → find second largest
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }

        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    // Optimal (Single Pass)
    // Time: O(n)
    // Space: O(1)
    public int optimal(int[] nums) {
        if (nums.length < 2) return -1;

        int largest = nums[0];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }

        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }
}
