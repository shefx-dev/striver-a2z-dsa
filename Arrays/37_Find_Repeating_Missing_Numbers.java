// Problem: Find the repeating and missing numbers in an array

// Brute Force Approach:
// - For each number from 1 to n, check its frequency in the array
// - If frequency == 2 → repeating number
// - If frequency == 0 → missing number
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach (Hashing / Frequency Array):
// - Use an auxiliary array of size n+1 to store frequencies
// - Traverse nums and increment frequency for each element
// - Traverse frequency array: 
//   - freq[i] == 2 → repeating
//   - freq[i] == 0 → missing
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Optimal Approach (Mathematical Equations):
// - Let sum of 1..n = S, sum of squares = SS
// - Compute actual sum and sum of squares from nums
// - Let val1 = (actualSum - S) = R - M
// - Let val2 = (actualSquares - SS) / val1 = R + M
// - Solve: R = (val1 + val2)/2, M = R - val1
// - Time Complexity: O(n)
// - Space Complexity: O(1)

class Solution {
    // Brute Force
    public int[] brute(int[] nums) {
        int n = nums.length;
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) count++;
            }
            if (count == 2) repeating = i;
            if (count == 0) missing = i;
        }
        return new int[]{repeating, missing};
    }

    // Better (Frequency Array)
    public int[] better(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n+1];
        for (int num : nums) {
            freq[num]++;
        }
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 2) repeating = i;
            if (freq[i] == 0) missing = i;
        }
        return new int[]{repeating, missing};
    }

    // Optimal (Math Equations)
    public int[] optimal(int[] nums) {
        int n = nums.length;
        long S = (long)n * (n+1) / 2;
        long SS = (long)n * (n+1) * (2L*n+1) / 6;

        long actualSum = 0, actualSquares = 0;
        for (int num : nums) {
            actualSum += num;
            actualSquares += (long)num * num;
        }

        long val1 = actualSum - S;              // R - M
        long val2 = (actualSquares - SS) / val1; // R + M

        long R = (val1 + val2) / 2;
        long M = R - val1;

        return new int[]{(int)R, (int)M};
    }

    // Test main
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {3, 5, 4, 1, 1};
        int[] nums2 = {1, 2, 3, 6, 7, 5, 7};

        System.out.println("Brute (nums1):   " + java.util.Arrays.toString(sol.brute(nums1)));
        System.out.println("Better (nums1):  " + java.util.Arrays.toString(sol.better(nums1)));
        System.out.println("Optimal (nums1): " + java.util.Arrays.toString(sol.optimal(nums1)));

        System.out.println("Brute (nums2):   " + java.util.Arrays.toString(sol.brute(nums2)));
        System.out.println("Better (nums2):  " + java.util.Arrays.toString(sol.better(nums2)));
        System.out.println("Optimal (nums2): " + java.util.Arrays.toString(sol.optimal(nums2)));
    }
}
