// Problem: Check if a given integer is a power of three
// Difficulty: Easy

// Hints:
// - A number is a power of three if it can be written as 3^k
// - Base cases: 1 is 3^0, 3 is 3^1, etc.
// - Recursive case: keep dividing by 3 until you reach 1

// Approach:
// - If n <= 0, return false
// - If n == 1, return true
// - If n % 3 != 0, return false
// - Otherwise recursively check n / 3

// Time Complexity: O(log₃ n)
// Space Complexity: O(log₃ n)

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPowerOfThree(27)); // true
        System.out.println(sol.isPowerOfThree(9));  // true
        System.out.println(sol.isPowerOfThree(10)); // false
    }
}
