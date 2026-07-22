// Problem: Print numbers from 1 to N using recursion
// Difficulty: Easy

// Hints:
// - Use recursion instead of loops
// - Think in terms of base case and recursive case
// - Base case: when n == 0, stop
// - Recursive case: call function with n-1, then print n

// Approach:
// - Define a recursive function printNumbers(n)
// - If n == 0, return (base case)
// - First recursively call printNumbers(n-1)
// - Then print n
// - This ensures numbers are printed in increasing order

// Time Complexity: O(n)
// Space Complexity: O(n) due to recursion stack

class Solution {

    public void printNumbers(int n) {
        if (n == 0) return; // base case
        printNumbers(n - 1); // recursive call
        System.out.println(n); // print after recursion
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5;
        sol.printNumbers(n);
    }
}
