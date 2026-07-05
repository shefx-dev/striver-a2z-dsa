// Problem: Kadane's Algorithm - Maximum Subarray Sum in an Array

// Brute Force Approach:
// - Generate all possible subarrays using nested loops
// - Calculate sum of each subarray
// - Track the maximum sum encountered
// - Time Complexity: O(n^2) or O(n^3) depending on implementation
// - Space Complexity: O(1)

// Better Approach (Prefix Sum):
// - Use prefix sums to calculate subarray sums faster
// - For each subarray, compute sum in O(1) using prefix array
// - Time Complexity: O(n^2)
// - Space Complexity: O(n)

// Optimal Approach (Kadane’s Algorithm):
// - Maintain two variables: currentSum and maxSum
// - Traverse the array:
//   - Add current element to currentSum
//   - If currentSum < current element, reset currentSum to current element
//   - Update maxSum with the maximum of maxSum and currentSum
// - Time Complexity: O(n)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public int brute(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // Better (Prefix Sum)
    public int better(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = prefix[j] - (i > 0 ? prefix[i - 1] : 0);
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // Optimal (Kadane’s Algorithm)
    public int optimal(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // either extend the current subarray or start new from nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
