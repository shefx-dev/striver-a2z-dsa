// Problem: Sort an array using Bubble Sort

// Brute Force Approach:
// - Compare every pair of elements (i, j) and swap if nums[i] > nums[j]
// - Repeat until array is sorted
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach:
// - Perform passes through the array
// - In each pass, bubble the largest element to the end by swapping adjacent elements
// - Repeat n-1 passes
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Optimal Approach (for Bubble Sort itself):
// - Same as Better, but stop early if no swaps occur in a pass (array already sorted)
// - Time Complexity: O(n^2) worst case, O(n) best case (already sorted)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public int[] brute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    // Better
    public int[] better(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    // Optimal
    public int[] optimal(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // stop early if no swaps
        }
        return nums;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {7, 4, 1, 5, 3};

        System.out.println("Brute: " + java.util.Arrays.toString(sol.brute(nums.clone())));
        System.out.println("Better: " + java.util.Arrays.toString(sol.better(nums.clone())));
        System.out.println("Optimal: " + java.util.Arrays.toString(sol.optimal(nums.clone())));
    }
}
