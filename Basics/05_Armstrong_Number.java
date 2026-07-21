// Problem: Check if a number is Armstrong Number or Not

// Brute Force Approach:
// - Convert the number to a string
// - For each digit, raise it to the power of total digits and sum
// - Compare sum with original number
// - Time Complexity: O(d) where d is number of digits
// - Space Complexity: O(d)

// Better Approach:
// - Extract digits using modulo and division
// - Raise each digit to the power of total digits and sum
// - Compare sum with original number
// - Time Complexity: O(d)
// - Space Complexity: O(1)

// Optimal Approach:
// - Same as Better (digit extraction is already optimal)
// - Time Complexity: O(d)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public boolean brute(int n) {
        String str = String.valueOf(n);
        int digits = str.length();
        int sum = 0;
        for (char c : str.toCharArray()) {
            int digit = c - '0';
            sum += Math.pow(digit, digits);
        }
        return sum == n;
    }

    // Better
    public boolean better(int n) {
        int original = n;
        int digits = String.valueOf(n).length();
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, digits);
            n /= 10;
        }
        return sum == original;
    }

    // Optimal (same as Better)
    public boolean optimal(int n) {
        int original = n;
        int digits = (int)Math.floor(Math.log10(n)) + 1;
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, digits);
            n /= 10;
        }
        return sum == original;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num1 = 153;
        int num2 = 371;
        int num3 = 123;

        System.out.println("Brute: " + sol.brute(num1));   // true
        System.out.println("Better: " + sol.better(num1)); // true
        System.out.println("Optimal: " + sol.optimal(num1)); // true

        System.out.println("Brute: " + sol.brute(num2));   // true
        System.out.println("Better: " + sol.better(num2)); // true
        System.out.println("Optimal: " + sol.optimal(num2)); // true

        System.out.println("Brute: " + sol.brute(num3));   // false
        System.out.println("Better: " + sol.better(num3)); // false
        System.out.println("Optimal: " + sol.optimal(num3)); // false
    }
}
