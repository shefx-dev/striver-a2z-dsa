// Problem: Check if a number is Prime or Not

// Brute Force Approach:
// - Count the number of divisors of N
// - If divisors == 2 → Prime, else Not Prime
// - Time Complexity: O(N)
// - Space Complexity: O(1)

// Better Approach:
// - Iterate from 2 to N-1
// - If any number divides N, it's not prime
// - Time Complexity: O(N)
// - Space Complexity: O(1)

// Optimal Approach:
// - Iterate only up to sqrt(N)
// - If any divisor found, not prime
// - Special cases: N <= 1 → Not Prime, N = 2 → Prime
// - Time Complexity: O(sqrt(N))
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public boolean brute(int n) {
        if (n <= 1) return false;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        return count == 2;
    }

    // Better
    public boolean better(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Optimal
    public boolean optimal(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num1 = 2;
        int num2 = 10;
        int num3 = 17;

        System.out.println("Brute: " + sol.brute(num1));   // true
        System.out.println("Better: " + sol.better(num1)); // true
        System.out.println("Optimal: " + sol.optimal(num1)); // true

        System.out.println("Brute: " + sol.brute(num2));   // false
        System.out.println("Better: " + sol.better(num2)); // false
        System.out.println("Optimal: " + sol.optimal(num2)); // false

        System.out.println("Brute: " + sol.brute(num3));   // true
        System.out.println("Better: " + sol.better(num3)); // true
        System.out.println("Optimal: " + sol.optimal(num3)); // true
    }
}
