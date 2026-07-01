// Problem: Remove Duplicates in-place from Sorted Array

// Brute Force Approach:
// - Use LinkedHashSet to remove duplicates while preserving order
// - Copy elements back to array
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Better Approach:
// - Use a temporary array to store unique elements
// - Copy back to original array
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Optimal Approach (Two Pointer):
// - Use two pointers (k and i)
// - Place unique elements in-place at the beginning
// - Time Complexity: O(n)
// - Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force (Using LinkedHashSet)
    public int brute(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();

        // Add elements (duplicates automatically removed)
        for (int num : nums) {
            set.add(num);
        }

        // Copy back to array
        int index = 0;
        for (int val : set) {
            nums[index++] = val;
        }

        return set.size();
    }

    // Better (Using Extra Array)
    public int better(int[] nums) {
        int n = nums.length;

        int[] temp = new int[n];
        int index = 0;

        temp[index++] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                temp[index++] = nums[i];
            }
        }

        // Copy back to original array
        for (int i = 0; i < index; i++) {
            nums[i] = temp[i];
        }

        return index;
    }

    // Optimal (Two Pointer Approach)
    public int optimal(int[] nums) {
        int n = nums.length;

        int k = 0; // index of last unique element

        for (int i = 1; i < n; i++) {
            if (nums[k] != nums[i]) {
                k++;
                nums[k] = nums[i];
            }
        }

        return k + 1; // number of unique elements
    }
}
``
