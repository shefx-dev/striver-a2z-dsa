// Problem: Calculate the nth Fibonacci number using recursion
// Difficulty: Easy

// Hints:
// - Fibonacci sequence is defined as:
//   F(0) = 0, F(1) = 1
//   F(n) = F(n-1) + F(n-2), for n > 1
// - Base cases: return 0 if n == 0, return 1 if n == 1
// - Recursive case: return fibonacci(n-1) + fibonacci(n-2)

// Approach:
// - Define a recursive function fibonacci(n)
// - If n == 0, return 0
// - If n == 1, return 1
// - Otherwise return fibonacci(n-1) + fibonacci(n-2)

// Time Complexity: O(2^n) (exponential due to repeated calls)
// Space Complexity: O(n) due to recursion stack

class Solution {

    public int fibonacci(int n) {
        if (n == 0) return 0; // base case
        if (n == 1) return 1; // base case
        return fibonacci(n - 1) + fibonacci(n - 2); // recursive case
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 2;
        System.out.println("Fibonacci of " + n1 + " is: " + sol.fibonacci(n1)); // Output: 1

        int n2 = 3;
        System.out.println("Fibonacci of " + n2 + " is: " + sol.fibonacci(n2)); // Output: 2

        int n3 = 5;
        System.out.println("Fibonacci of " + n3 + " is: " + sol.fibonacci(n3)); // Output: 5
    }
}
