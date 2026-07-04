// Problem: Sort an array of 0s, 1s and 2s

// Brute Force Approach:
// - Use any built-in sorting algorithm (like Arrays.sort())
// - This works but does not leverage the fact that elements are only 0, 1, 2
// - Time Complexity: O(n log n)
// - Space Complexity: O(1)

// Better Approach (Counting Sort):
// - Count the number of 0s, 1s, and 2s
// - Overwrite the array with that many 0s, then 1s, then 2s
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Optimal Approach (Dutch National Flag Algorithm):
// - Use three pointers: low, mid, high
// - Partition the array in a single traversal
// - Swap elements into correct regions in-place
// - Time Complexity: O(n)
// - Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public void brute(int[] nums) {
        Arrays.sort(nums);
    }

    // Better (Counting Sort)
    public void better(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }
        int index = 0;
        while (count0-- > 0) nums[index++] = 0;
        while (count1-- > 0) nums[index++] = 1;
        while (count2-- > 0) nums[index++] = 2;
    }

    // Optimal (Dutch National Flag Algorithm)
    public void optimal(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++; mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}
