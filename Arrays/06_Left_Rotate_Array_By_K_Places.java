// Problem: Left Rotate Array by K Places

// Brute Force Approach:
// - Rotate the array left by 1 step, repeat this K times
// - Each rotation shifts all elements left by one
// - Time Complexity: O(n * k)
// - Space Complexity: O(1)

// Better Approach:
// - Use an extra array
// - For each index i, place nums[i] at position (i - k + n) % n
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Optimal Approach:
// - Use the reversal algorithm
// - Reverse first k elements
// - Reverse remaining n-k elements
// - Reverse the entire array
// - Time Complexity: O(n)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public void brute(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handle large k

        for (int r = 0; r < k; r++) {
            int first = nums[0];
            for (int i = 0; i < n - 1; i++) {
                nums[i] = nums[i + 1];
            }
            nums[n - 1] = first;
        }
    }

    // Better
    public void better(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i - k + n) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    // Optimal
    public void optimal(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // reverse first k elements
        reverse(nums, 0, k - 1);

        // reverse remaining elements
        reverse(nums, k, n - 1);

        // reverse entire array
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
