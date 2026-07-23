// Problem: Implement pow(x, n) which calculates x raised to the power n
// Difficulty: Medium

// Hints:
// - Use recursion with divide-and-conquer
// - If n == 0, return 1
// - If n < 0, compute 1 / pow(x, -n)
// - If n is even, pow(x, n) = pow(x*x, n/2)
// - If n is odd, pow(x, n) = x * pow(x, n-1)

// Approach:
// - Handle base cases (n == 0, n < 0)
// - Use recursion with halving for efficiency

// Time Complexity: O(log n)
// Space Complexity: O(log n)

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / myPow(x, -n);
        if (n % 2 == 0) return myPow(x * x, n / 2);
        return x * myPow(x, n - 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myPow(2, 10));  // 1024.0
        System.out.println(sol.myPow(2, -2));  // 0.25
        System.out.println(sol.myPow(3, 3));   // 27.0
    }
}
