// Problem: Count Reverse Pairs in an array
// Definition: A reverse pair is (i, j) such that i < j and arr[i] > 2*arr[j].

// Brute Force Approach:
// - For every pair (i, j) with i < j, check if arr[i] > 2*arr[j]
// - Increment count if condition is satisfied
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach (Balanced BST / Fenwick Tree):
// - Traverse array from left to right
// - For each element, count how many elements already seen are greater than 2*arr[j]
// - Use a Balanced BST or Fenwick Tree for efficient queries
// - Time Complexity: O(n log n)
// - Space Complexity: O(n)

// Optimal Approach (Modified Merge Sort):
// - Use merge sort to count reverse pairs across halves
// - Before merging, for each element in left half, count how many elements in right half satisfy arr[i] > 2*arr[j]
// - Since halves are sorted, use two pointers to count efficiently
// - Merge halves as usual
// - Time Complexity: O(n log n)
// - Space Complexity: O(n)

class Solution {
    // Brute Force
    public int brute(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if ((long)arr[i] > 2L * arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Optimal (Merge Sort)
    public int optimal(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSortHelper(arr, temp, 0, n-1);
    }

    private int mergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left)/2;
        int count = 0;
        count += mergeSortHelper(arr, temp, left, mid);
        count += mergeSortHelper(arr, temp, mid+1, right);
        count += countCrossPairs(arr, left, mid, right);
        merge(arr, temp, left, mid, right);
        return count;
    }

    private int countCrossPairs(int[] arr, int left, int mid, int right) {
        int count = 0;
        int j = mid+1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long)arr[i] > 2L * arr[j]) {
                j++;
            }
            count += (j - (mid+1));
        }
        return count;
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int k = left; k <= right; k++) {
            temp[k] = arr[k];
        }
        int i = left, j = mid+1, k = left;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid) arr[k++] = temp[i++];
        while (j <= right) arr[k++] = temp[j++];
    }

    // Test main
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {1,3,2,3,1};
        int[] arr2 = {3,2,1,4};

        System.out.println("Brute (arr1):   " + sol.brute(arr1));   // 2
        System.out.println("Optimal (arr1): " + sol.optimal(arr1)); // 2

        System.out.println("Brute (arr2):   " + sol.brute(arr2));   // 1
        System.out.println("Optimal (arr2): " + sol.optimal(arr2)); // 1
    }
}
