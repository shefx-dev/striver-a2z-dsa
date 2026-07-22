// Problem: Check if a given string is palindrome using recursion
// Difficulty: Easy

// Hints:
// - A string is palindrome if it reads the same forward and backward
// - Base case: if start >= end, return true
// - Recursive case: check if s[start] == s[end], then recurse inward
// - If any mismatch occurs, return false immediately

// Approach:
// - Define a recursive function isPalindrome(s, start, end)
// - If start >= end, return true (base case)
// - If s[start] != s[end], return false
// - Otherwise recurse with start+1 and end-1
// - This ensures characters are checked symmetrically

// Time Complexity: O(n)
// Space Complexity: O(n) due to recursion stack

class Solution {

    public boolean isPalindrome(String s) {
        return isPalindromeHelper(s, 0, s.length() - 1);
    }

    private boolean isPalindromeHelper(String s, int start, int end) {
        if (start >= end) return true; // base case
        if (s.charAt(start) != s.charAt(end)) return false; // mismatch
        return isPalindromeHelper(s, start + 1, end - 1); // recursive call
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "hannah";
        System.out.println("Is '" + s1 + "' palindrome? " + sol.isPalindrome(s1)); // true

        String s2 = "aabbaA";
        System.out.println("Is '" + s2 + "' palindrome? " + sol.isPalindrome(s2)); // false
    }
}
