// Problem: Print numbers from N to 1 using recursion
// Difficulty: Easy

// Hints:
// - Use recursion instead of loops
// - Think in terms of base case and recursive case
// - Base case: when n == 0, stop
// - Recursive case: print n first, then call function with n-1

// Approach:
// - Define a recursive function printNumbersReverse(n)
// - If n == 0, return (base case)
// - Print n before the recursive call
// - Then recursively call printNumbersReverse(n-1)
// - This ensures numbers are printed in decreasing order

// Time Complexity: O(n)
// Space Complexity: O(n) due to recursion stack

class Solution {

    public void printNumbersReverse(int n) {
        if (n == 0) return; // base case
        System.out.println(n); // print before recursion
        printNumbersReverse(n - 1); // recursive call
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 5;
        sol.printNumbersReverse(n);
    }
}
