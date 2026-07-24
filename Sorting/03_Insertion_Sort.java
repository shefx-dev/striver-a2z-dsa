class Solution {

    // Brute Force:
    // - For each element, compare with all previous elements
    // - Swap until it is in the correct position
    // - Time Complexity: O(n^2)
    // - Space Complexity: O(1)
    public int[] brute(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        return nums;
    }

    // Better:
    // - Instead of swapping repeatedly, shift elements until the correct spot is found
    // - Insert the current element directly into its position
    // - Time Complexity: O(n^2)
    // - Space Complexity: O(1)
    public int[] better(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j]; // shift right
                j--;
            }
            nums[j + 1] = key; // insert key
        }
        return nums;
    }

    // Optimal:
    // - Same as Better, but naturally stops early when array is already sorted
    // - Best case: O(n) when input is sorted
    // - Worst case: O(n^2)
    // - Space Complexity: O(1)
    public int[] optimal(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            // stop early when nums[j] <= key
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
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
