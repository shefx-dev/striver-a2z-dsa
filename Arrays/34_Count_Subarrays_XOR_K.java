// Problem: Count the Number of Subarrays with Given XOR K

// Brute Force Approach:
// - For every pair (i, j), compute the XOR of subarray [i..j] from scratch
// - If XOR == k, increment the count
// - Time Complexity: O(n^3)
// - Space Complexity: O(1)

// Better Approach (Running XOR + Nested Loop):
// - Fix the starting index i and extend j, maintaining a running XOR
//   (avoids recomputing XOR from scratch for every pair)
// - If running XOR == k at any point, increment the count
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Optimal Approach (Prefix XOR + HashMap):
// - Maintain a running prefix XOR while traversing the array
// - If prefix XOR == k at index i, the subarray [0..i] itself has XOR k -> count it
// - For a subarray [j+1..i] to have XOR k: prefixXor[i] ^ prefixXor[j] = k
//   => prefixXor[j] = prefixXor[i] ^ k  (since x ^ x = 0)
// - So at each index, check how many times (prefixXor[i] ^ k) has occurred before
//   using a HashMap storing frequency of each prefix XOR value
// - Time Complexity: O(n)
// - Space Complexity: O(n)

import java.util.*;

class Solution {
    // Brute Force
    public int brute(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xorVal = 0;
                for (int m = i; m <= j; m++) {
                    xorVal ^= arr[m];
                }
                if (xorVal == k) count++;
            }
        }
        return count;
    }

    // Better (Running XOR + Nested Loop)
    public int better(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int xorVal = 0;
            for (int j = i; j < n; j++) {
                xorVal ^= arr[j];
                if (xorVal == k) count++;
            }
        }
        return count;
    }

    // Optimal (Prefix XOR + HashMap)
    public int optimal(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = arr.length;
        int prefixXor = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            prefixXor ^= arr[i];

            if (prefixXor == k) {
                count++;
            }

            int required = prefixXor ^ k;
            if (freq.containsKey(required)) {
                count += freq.get(required);
            }

            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }

    // Test main
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {4, 2, 2, 6, 4};
        int k1 = 6;

        int[] arr2 = {5, 6, 7, 8, 9};
        int k2 = 5;

        System.out.println("Brute (arr1):   " + sol.brute(arr1, k1));
        System.out.println("Better (arr1):  " + sol.better(arr1, k1));
        System.out.println("Optimal (arr1): " + sol.optimal(arr1, k1));

        System.out.println("Brute (arr2):   " + sol.brute(arr2, k2));
        System.out.println("Better (arr2):  " + sol.better(arr2, k2));
        System.out.println("Optimal (arr2): " + sol.optimal(arr2, k2));
    }
}
