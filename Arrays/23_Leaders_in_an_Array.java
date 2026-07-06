// Problem: Leaders in an Array
// An element is a leader if it is greater than or equal to all elements to its right.
// The rightmost element is always a leader.

// Brute Force Approach:
// - For each element, check all elements to its right.
// - If it is greater than or equal to all, mark it as leader.
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach:
// - Precompute a suffix max array.
// - Compare each element with the max to its right.
// - If element >= suffix max, it is a leader.
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Optimal Approach:
// - Traverse from right to left, keep track of the maximum seen so far.
// - If current element >= max so far, it is a leader.
// - Reverse collected leaders to maintain original order.
// - Time Complexity: O(n)
// - Space Complexity: O(1) (apart from result list)

import java.util.*;

class Solution {

    // Brute Force
    public List<Integer> brute(int[] arr) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) leaders.add(arr[i]);
        }
        return leaders;
    }

    // Better
    public List<Integer> better(int[] arr) {
        int n = arr.length;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = arr[n - 1];
        
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(arr[i], suffixMax[i + 1]);
        }
        
        List<Integer> leaders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] >= suffixMax[i]) {
                leaders.add(arr[i]);
            }
        }
        return leaders;
    }

    // Optimal
    public List<Integer> optimal(int[] arr) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();
        
        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight); // rightmost element is always leader
        
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                leaders.add(arr[i]);
                maxFromRight = arr[i];
            }
        }
        
        Collections.reverse(leaders); // restore original order
        return leaders;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1 = {4, 7, 1, 0};
        int[] arr2 = {10, 22, 12, 3, 0, 6};
        
        System.out.println("Brute: " + sol.brute(arr1));
        System.out.println("Better: " + sol.better(arr1));
        System.out.println("Optimal: " + sol.optimal(arr1));
        
        System.out.println("Brute: " + sol.brute(arr2));
        System.out.println("Better: " + sol.better(arr2));
        System.out.println("Optimal: " + sol.optimal(arr2));
    }
}
