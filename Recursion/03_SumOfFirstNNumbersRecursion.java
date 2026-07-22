// Problem: Return the sum of first N natural numbers using recursion
// Difficulty: Easy

// Hints:
// - Use recursion instead of loops
// - Think in terms of base case and recursive case
// - Base case: when n == 0, return 0
// - Recursive case: return n + sum(n-1)

// Approach:
// - Define a recursive function sumOfN(n)
// - If n == 0, return 0 (base case)
// - Otherwise return n + sumOfN(n-1)
// - This ensures the sum is built up from smaller subproblems

// Time Complexity: O(n)
// Space Complexity: O(n) due to recursion stack

class Solution {

    public int sumOfN(int n) {
        if (n == 0) return 0; // base case
        return n + sumOfN(n - 1); // recursive case
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 4;
        System.out.println("Sum of first " + n1 + " numbers: " + sol.sumOfN(n1)); // Output: 10

        int n2 = 2;
        System.out.println("Sum of first " + n2 + " numbers: " + sol.sumOfN(n2)); // Output: 3

        int n3 = 10;
        System.out.println("Sum of first " + n3 + " numbers: " + sol.sumOfN(n3)); // Output: 55
    }
}
