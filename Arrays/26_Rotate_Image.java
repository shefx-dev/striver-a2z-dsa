// Problem: Rotate Image by 90 Degrees
// Given an N x N matrix, rotate the matrix by 90 degrees clockwise in place.

// Brute Force Approach:
// - Create a new matrix of the same size.
// - For each element at (i, j), place it at (j, n-1-i) in the new matrix.
// - Copy the new matrix back to the original.
// - Time Complexity: O(n^2)
// - Space Complexity: O(n^2)

// Better Approach:
// - Transpose the matrix (swap matrix[i][j] with matrix[j][i]).
// - Then reverse each row.
// - This simulates a 90° clockwise rotation.
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Optimal Approach:
// - Same as Better (transpose + reverse rows).
// - Done in place, no extra space.
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public void brute(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }

        // Copy back to original
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotated[i][j];
            }
        }
    }

    // Better
    public void better(int[][] matrix) {
        int n = matrix.length;

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    // Optimal (same as Better)
    public void optimal(int[][] matrix) {
        int n = matrix.length;

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
