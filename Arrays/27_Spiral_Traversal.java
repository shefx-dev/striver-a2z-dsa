// Problem: Spiral Traversal of Matrix
// Given a matrix, print the elements in spiral order.

// Brute Force Approach:
// - Use extra visited[][] array to track visited cells.
// - Simulate movement in directions (right, down, left, up).
// - Stop when all elements are visited.
// - Time Complexity: O(n*m)
// - Space Complexity: O(n*m)

// Better Approach:
// - Use boundary variables: top, bottom, left, right.
// - Traverse in spiral order by adjusting boundaries after each pass.
// - Collect elements in a list.
// - Time Complexity: O(n*m)
// - Space Complexity: O(1) (excluding output list)

// Optimal Approach:
// - Same as Better (boundary method).
// - Efficient and in-place traversal without extra visited array.
// - Time Complexity: O(n*m)
// - Space Complexity: O(1)

import java.util.*;

class Solution {

    // Brute Force
    public List<Integer> brute(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        List<Integer> result = new ArrayList<>();

        int total = n * m;
        int i = 0, j = 0;
        int dir = 0; // 0=right,1=down,2=left,3=up

        while (result.size() < total) {
            result.add(matrix[i][j]);
            visited[i][j] = true;

            if (dir == 0) { // right
                if (j + 1 < m && !visited[i][j + 1]) j++;
                else { dir = 1; i++; }
            } else if (dir == 1) { // down
                if (i + 1 < n && !visited[i + 1][j]) i++;
                else { dir = 2; j--; }
            } else if (dir == 2) { // left
                if (j - 1 >= 0 && !visited[i][j - 1]) j--;
                else { dir = 3; i--; }
            } else { // up
                if (i - 1 >= 0 && !visited[i - 1][j]) i--;
                else { dir = 0; j++; }
            }
        }
        return result;
    }

    // Better
    public List<Integer> better(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        int top = 0, bottom = n - 1, left = 0, right = m - 1;

        while (top <= bottom && left <= right) {
            // Traverse top row
            for (int j = left; j <= right; j++) result.add(matrix[top][j]);
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;

            // Traverse bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) result.add(matrix[bottom][j]);
                bottom--;
            }

            // Traverse left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }

    // Optimal (same as Better)
    public List<Integer> optimal(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        int top = 0, bottom = n - 1, left = 0, right = m - 1;

        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) result.add(matrix[top][j]);
            top++;

            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) result.add(matrix[bottom][j]);
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }
}
