// Problem: Reverse an array in place using recursion
// Difficulty: Easy

// Approach:
// - Use a helper function with two pointers: start and end
// - Base case: if start >= end, stop
// - Swap arr[start] and arr[end], then recurse inward

import java.util.Arrays;

class Solution {

    public void reverse(int[] arr, int n) {
        reverseHelper(arr, 0, n - 1);
    }

    private void reverseHelper(int[] arr, int start, int end) {
        if (start >= end) return; // base case
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseHelper(arr, start + 1, end - 1); // recursive call
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 2, 3, 4, 5};
        sol.reverse(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1)); // [5,4,3,2,1]

        int[] arr2 = {1, 2, 1, 1, 5, 1};
        sol.reverse(arr2, arr2.length);
        System.out.println(Arrays.toString(arr2)); // [1,5,1,1,2,1]

        int[] arr3 = {1, 2, 1};
        sol.reverse(arr3, arr3.length);
        System.out.println(Arrays.toString(arr3)); // [1,2,1]
    }
}
