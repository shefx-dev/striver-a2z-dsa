// Problem: Reverse Digits of a Number

// Brute Force Approach:
// - Convert the number to a string
// - Reverse the string and convert back to integer
// - Time Complexity: O(d) where d is number of digits
// - Space Complexity: O(d)

// Better Approach:
// - Extract digits one by one using modulo and division
// - Build the reversed number iteratively
// - Time Complexity: O(d)
// - Space Complexity: O(1)

// Optimal Approach:
// - Same as Better (digit extraction is already optimal)
// - Time Complexity: O(d)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public int brute(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }

    // Better
    public int better(int n) {
        int reversed = 0;
        while (n > 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return reversed;
    }

    // Optimal (same as Better)
    public int optimal(int n) {
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + (n % 10);
            n /= 10;
        }
        return reversed;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num1 = 12345;
        int num2 = 10400;

        System.out.println("Brute: " + sol.brute(num1));   // 54321
        System.out.println("Better: " + sol.better(num1)); // 54321
        System.out.println("Optimal: " + sol.optimal(num1)); // 54321

        System.out.println("Brute: " + sol.brute(num2));   // 401
        System.out.println("Better: " + sol.better(num2)); // 401
        System.out.println("Optimal: " + sol.optimal(num2)); // 401
    }
}
