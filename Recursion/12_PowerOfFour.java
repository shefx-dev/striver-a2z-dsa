// Problem: Check if a given integer is a power of four
// Difficulty: Easy

// Hints:
// - A number is a power of four if it can be written as 4^k
// - Base cases: 1 is 4^0, 4 is 4^1, etc.
// - Recursive case: keep dividing by 4 until you reach 1
// - Negative numbers and zero are not powers of four

// Approach:
// - If n <= 0, return false
// - If n == 1, return true
// - If n % 4 != 0, return false
// - Otherwise recursively check n / 4

// Time Complexity: O(log₄ n)
// Space Complexity: O(log₄ n) due to recursion stack

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 4 != 0) return false;
        return isPowerOfFour(n / 4);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPowerOfFour(16)); // true
        System.out.println(sol.isPowerOfFour(8));  // false
        System.out.println(sol.isPowerOfFour(64)); // true
    }
}
