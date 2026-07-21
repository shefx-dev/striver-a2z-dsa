// Problem: Check if a number is Palindrome or Not

// Brute Force Approach:
// - Convert the number to a string
// - Reverse the string and compare with original
// - Time Complexity: O(d) where d is number of digits
// - Space Complexity: O(d)

// Better Approach:
// - Reverse the number using digit extraction
// - Compare reversed number with original
// - Time Complexity: O(d)
// - Space Complexity: O(1)

// Optimal Approach:
// - Reverse only half of the number and compare with the other half
// - Avoids reversing the entire number (slightly more efficient for very large inputs)
// - Time Complexity: O(d/2) ≈ O(d)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public boolean brute(int n) {
        String str = String.valueOf(n);
        String rev = new StringBuilder(str).reverse().toString();
        return str.equals(rev);
    }

    // Better
    public boolean better(int n) {
        int original = n;
        int reversed = 0;
        while (n > 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return original == reversed;
    }

    // Optimal
    public boolean optimal(int n) {
        if (n < 0 || (n % 10 == 0 && n != 0)) return false;

        int reversedHalf = 0;
        while (n > reversedHalf) {
            reversedHalf = reversedHalf * 10 + n % 10;
            n /= 10;
        }
        // For odd digit numbers, ignore the middle digit
        return (n == reversedHalf || n == reversedHalf / 10);
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num1 = 4554;
        int num2 = 7789;

        System.out.println("Brute: " + (sol.brute(num1) ? "Palindrome Number" : "Not Palindrome"));
        System.out.println("Better: " + (sol.better(num1) ? "Palindrome Number" : "Not Palindrome"));
        System.out.println("Optimal: " + (sol.optimal(num1) ? "Palindrome Number" : "Not Palindrome"));

        System.out.println("Brute: " + (sol.brute(num2) ? "Palindrome Number" : "Not Palindrome"));
        System.out.println("Better: " + (sol.better(num2) ? "Palindrome Number" : "Not Palindrome"));
        System.out.println("Optimal: " + (sol.optimal(num2) ? "Palindrome Number" : "Not Palindrome"));
    }
}
