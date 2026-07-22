// Problem: Return the factorial of a given number using recursion
// Difficulty: Easy

// Hints:
// - Factorial of n (n!) = n * (n-1) * (n-2) ... * 1
// - Base case: 0! = 1 (by definition)
// - Recursive case: n! = n * (n-1)!

// Approach:
// - Define a recursive function factorial(n)
// - If n == 0, return 1 (base case)
// - Otherwise return n * factorial(n-1)
// - This builds the factorial step by step

// Time Complexity: O(n)
// Space Complexity: O(n) due to recursion stack

class Solution {

    public int factorial(int n) {
        if (n == 0) return 1; // base case
        return n * factorial(n - 1); // recursive case
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int n1 = 2;
        System.out.println("Factorial of " + n1 + " is: " + sol.factorial(n1)); // Output: 2

        int n2 = 0;
        System.out.println("Factorial of " + n2 + " is: " + sol.factorial(n2)); // Output: 1

        int n3 = 5;
        System.out.println("Factorial of " + n3 + " is: " + sol.factorial(n3)); // Output: 120
    }
}
