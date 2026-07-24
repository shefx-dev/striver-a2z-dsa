// Problem: Sort an array using Selection Sort

// Brute Force Approach:
// - For each index i, scan the entire array to find the minimum element
// - Swap it with nums[i]
// - Time Complexity: O(n^2) (redundant scans)
// - Space Complexity: O(1)

// Better Approach:
// - For each index i, scan only the unsorted portion (i..n-1) to find the minimum
// - Swap it with nums[i]
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Optimal Approach (for Selection Sort itself):
// - Same as Better, but swap only if minIndex != i (avoids unnecessary writes)
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public int[] brute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = 0; j < nums.length; j++) { // scans whole array
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    // Better
    public int[] better(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) { // only unsorted part
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    // Optimal
    public int[] optimal(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) { // swap only if needed
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
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
