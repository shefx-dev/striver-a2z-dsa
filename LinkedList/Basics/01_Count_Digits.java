// Problem: Count Digits in a Number

class Solution {

    // Brute Force Approach:
    // - Convert the number to a string and return its length
    // - Time Complexity: O(d) where d is number of digits
    // - Space Complexity: O(d)
    public int brute(int n) {
        return String.valueOf(n).length();
    }

    // Better Approach:
    // - Repeatedly divide the number by 10 until it becomes 0
    // - Count the number of divisions
    // - Time Complexity: O(d)
    // - Space Complexity: O(1)
    public int better(int n) {
        if (n == 0) return 1;
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    // Optimal Approach:
    // - Use logarithm: digits = floor(log10(n)) + 1
    // - Special case: if n == 0, return 1
    // - Time Complexity: O(1)
    // - Space Complexity: O(1)
    public int optimal(int n) {
        if (n == 0) return 1;
        return (int)Math.floor(Math.log10(n)) + 1;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num = 12345;

        System.out.println("Brute: " + sol.brute(num));
        System.out.println("Better: " + sol.better(num));
        System.out.println("Optimal: " + sol.optimal(num));
    }
}
