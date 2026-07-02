// Problem: Left Rotate Array by One

// Brute Force Approach:
// - Rotate the array one step using nested loops
// - Store the first element, shift all elements left, repeat once
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach:
// - Use an extra array to store the rotated version
// - Copy elements from index 1 to end, place first element at last
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Optimal Approach:
// - Store the first element
// - Shift all elements left by one
// - Place stored element at the end
// - Time Complexity: O(n)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public void brute(int[] nums) {
        int n = nums.length;

        // rotate once using nested shifting
        for (int r = 0; r < 1; r++) {
            int first = nums[0];
            for (int i = 0; i < n - 1; i++) {
                nums[i] = nums[i + 1];
            }
            nums[n - 1] = first;
        }
    }

    // Better
    public void better(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];

        // shift elements to temp
        for (int i = 1; i < n; i++) {
            temp[i - 1] = nums[i];
        }

        // place first element at end
        temp[n - 1] = nums[0];

        // copy back
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    // Optimal
    public void optimal(int[] nums) {
        int first = nums[0];

        // shift left by one
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        // place first element at end
        nums[nums.length - 1] = first;
    }
}
