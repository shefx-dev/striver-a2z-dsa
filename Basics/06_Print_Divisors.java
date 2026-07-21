// Problem: Print all Divisors of a given Number

// Brute Force Approach:
// - Iterate from 1 to N
// - Check if each number divides N without remainder
// - Collect all divisors
// - Time Complexity: O(N)
// - Space Complexity: O(1)

// Better Approach:
// - Iterate from 1 to sqrt(N)
// - If i divides N, add both i and N/i
// - Avoid duplicates when i == N/i
// - Time Complexity: O(sqrt(N))
// - Space Complexity: O(1)

// Optimal Approach:
// - Same as Better, but store divisors in sorted order
// - Use two lists: one for smaller divisors, one for larger
// - Combine at the end
// - Time Complexity: O(sqrt(N))
// - Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public List<Integer> brute(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    // Better
    public List<Integer> better(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }
        Collections.sort(divisors);
        return divisors;
    }

    // Optimal
    public List<Integer> optimal(int n) {
        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                small.add(i);
                if (i != n / i) {
                    large.add(n / i);
                }
            }
        }
        Collections.reverse(large);
        small.addAll(large);
        return small;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int num1 = 36;
        int num2 = 12;

        System.out.println("Brute: " + sol.brute(num1));   // [1, 2, 3, 4, 6, 9, 12, 18, 36]
        System.out.println("Better: " + sol.better(num1)); // [1, 2, 3, 4, 6, 9, 12, 18, 36]
        System.out.println("Optimal: " + sol.optimal(num1)); // [1, 2, 3, 4, 6, 9, 12, 18, 36]

        System.out.println("Brute: " + sol.brute(num2));   // [1, 2, 3, 4, 6, 12]
        System.out.println("Better: " + sol.better(num2)); // [1, 2, 3, 4, 6, 12]
        System.out.println("Optimal: " + sol.optimal(num2)); // [1, 2, 3, 4, 6, 12]
    }
}
