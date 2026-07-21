// Problem: GCD of Two Numbers

// Brute Force Approach:
// - Find all divisors of both numbers
// - Compare and return the largest common divisor
// - Time Complexity: O(min(n1, n2))
// - Space Complexity: O(1)

// Better Approach:
// - Start from min(n1, n2) and check downwards
// - First divisor found is the GCD
// - Time Complexity: O(min(n1, n2))
// - Space Complexity: O(1)

// Optimal Approach (Euclidean Algorithm):
// - Use recursion or iteration: gcd(a, b) = gcd(b, a % b)
// - Time Complexity: O(log(min(n1, n2)))
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public int brute(int n1, int n2) {
        int gcd = 1;
        for (int i = 1; i <= Math.min(n1, n2); i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    // Better
    public int better(int n1, int n2) {
        int min = Math.min(n1, n2);
        for (int i = min; i >= 1; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                return i;
            }
        }
        return 1;
    }

    // Optimal (Euclidean Algorithm)
    public int optimal(int n1, int n2) {
        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n1 = 4, n2 = 6;
        int n3 = 9, n4 = 8;

        System.out.println("Brute: " + sol.brute(n1, n2));   // 2
        System.out.println("Better: " + sol.better(n1, n2)); // 2
        System.out.println("Optimal: " + sol.optimal(n1, n2)); // 2

        System.out.println("Brute: " + sol.brute(n3, n4));   // 1
        System.out.println("Better: " + sol.better(n3, n4)); // 1
        System.out.println("Optimal: " + sol.optimal(n3, n4)); // 1
    }
}
