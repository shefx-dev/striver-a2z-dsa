// Problem: Program to generate Pascal's Triangle

// Brute Force Approach:
// - Build the entire Pascal’s Triangle using a 2D array
// - Each element is Pascal[r][c] = Pascal[r-1][c-1] + Pascal[r-1][c]
// - Time Complexity: O(N^2)
// - Space Complexity: O(N^2)

// Better Approach:
// - Compute only the N-th row using a 1D array
// - Update values from right to left to avoid overwriting
// - Time Complexity: O(N^2)
// - Space Complexity: O(N)

// Optimal Approach:
// - Directly compute element at (r, c) using binomial coefficient
// - Formula: C(r-1, c-1)
// - Time Complexity: O(c)
// - Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force: build full triangle
    public int brute(int N, int r, int c) {
        int[][] pascal = new int[N][N];
        pascal[0][0] = 1;

        for (int i = 1; i < N; i++) {
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
            }
        }
        return pascal[r-1][c-1];
    }

    // Better: compute only N-th row
    public int better(int N, int r, int c) {
        int[] row = new int[N];
        row[0] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                row[j] = row[j] + row[j-1];
            }
        }
        return row[c-1]; // element at (r, c)
    }

    // Optimal: use binomial coefficient
    public int optimal(int r, int c) {
        int n = r - 1;
        int k = c - 1;
        long res = 1;

        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
        }
        return (int) res;
    }

    // Utility: print first N rows of Pascal’s Triangle
    public void printPascal(int N) {
        for (int i = 0; i < N; i++) {
            int val = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(val + " ");
                val = val * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    // Demo main
    public static void main(String[] args) {
        Solution sol = new Solution();
        int N = 5, r = 5, c = 3;

        System.out.println("Brute: " + sol.brute(N, r, c));
        System.out.println("Better: " + sol.better(N, r, c));
        System.out.println("Optimal: " + sol.optimal(r, c));

        System.out.println("First " + N + " rows of Pascal’s Triangle:");
        sol.printPascal(N);
    }
}
