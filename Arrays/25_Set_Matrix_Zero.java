// Problem: Set Matrix Zero
// Given a matrix, if an element is 0 then set its entire row and column to 0.

// Brute Force Approach:
// - Traverse the matrix, whenever a 0 is found mark its row and column with -1 (placeholder).
// - After traversal, convert all -1 to 0.
// - Time Complexity: O(n^3)
// - Space Complexity: O(1)

// Better Approach:
// - Use two extra arrays to mark rows and columns that need to be zeroed.
// - Traverse once to mark, then traverse again to set zeros.
// - Time Complexity: O(n*m)
// - Space Complexity: O(n+m)

// Optimal Approach:
// - Use the first row and first column of the matrix itself as markers.
// - Keep two flags for whether the first row and column should be zeroed.
// - Traverse and mark, then update cells based on markers.
// - Finally handle first row and column separately.
// - Time Complexity: O(n*m)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public void brute(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Mark row
                    for (int k = 0; k < m; k++) {
                        if (matrix[i][k] != 0) matrix[i][k] = -1;
                    }
                    // Mark column
                    for (int k = 0; k < n; k++) {
                        if (matrix[k][j] != 0) matrix[k][j] = -1;
                    }
                }
            }
        }

        // Convert -1 to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = 0;
            }
        }
    }

    // Better
    public void better(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Optimal
    public void optimal(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean firstRowZero = false, firstColZero = false;

        // Check first row
        for (int j = 0; j < m; j++) {
            if (matrix[0][j] == 0) firstRowZero = true;
        }

        // Check first column
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) firstColZero = true;
        }

        // Use first row/col as markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set cells based on markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle first row
        if (firstRowZero) {
            for (int j = 0; j < m; j++) matrix[0][j] = 0;
        }

        // Handle first column
        if (firstColZero) {
            for (int i = 0; i < n; i++) matrix[i][0] = 0;
        }
    }
}
