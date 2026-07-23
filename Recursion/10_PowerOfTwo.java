// Problem: Check if a given integer is a power of two
// Difficulty: Easy

// Hints:
// - A number is a power of two if it can be written as 2^k
// - Base cases: 1 is 2^0, 2 is 2^1, etc.
// - Recursive case: keep dividing by 2 until you reach 1

// Approach:
// - If n <= 0, return false
// - If n == 1, return true
// - If n % 2 != 0, return false
// - Otherwise recursively check n / 2

// Time Complexity: O(log₂ n)
// Space Complexity: O(log₂ n)

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPowerOfTwo(16)); // true
        System.out.println(sol.isPowerOfTwo(18)); // false
        System.out.println(sol.isPowerOfTwo(1));  // true
    }
}
