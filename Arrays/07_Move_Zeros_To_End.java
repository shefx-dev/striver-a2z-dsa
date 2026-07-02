// Problem: Move Zeros to End

// Brute Force Approach:
// - Use an extra array
// - Copy all non-zero elements first, then fill remaining positions with zeros
// - Finally copy back to original array
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Better Approach:
// - Shift all non-zero elements to the front
// - Then fill the remaining positions with zeros
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Optimal Approach:
// - Use two pointers (i and j)
// - i scans the array, j marks the position to place the next non-zero
// - Swap nums[i] with nums[j] when nums[i] != 0
// - Maintains order and minimizes writes
// - Time Complexity: O(n)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public void brute(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int index = 0;

        // collect non-zero elements
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp[index++] = nums[i];
            }
        }

        // fill remaining with zeros
        while (index < n) {
            temp[index++] = 0;
        }

        // copy back
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    // Better
    public void better(int[] nums) {
        int n = nums.length;
        int index = 0;

        // move non-zero elements forward
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        // fill remaining with zeros
        while (index < n) {
            nums[index++] = 0;
        }
    }

    // Optimal
    public void optimal(int[] nums) {
        int j = 0; // pointer for placing non-zero elements

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // swap only when needed
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
