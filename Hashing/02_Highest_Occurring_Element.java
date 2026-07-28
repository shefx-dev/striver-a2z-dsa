// Problem: Find the Highest Occurring Element in an Array

// Brute Force Approach:
// - For each element, count its frequency by scanning the array
// - Track the element with maximum frequency
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach:
// - Sort the array, then count consecutive duplicates
// - Track the element with maximum frequency
// - Time Complexity: O(n log n)
// - Space Complexity: O(1)

// Optimal Approach:
// - Use a HashMap to store frequencies
// - Find the element with maximum frequency
// - Time Complexity: O(n)
// - Space Complexity: O(n)

import java.util.*;

class HighestOccurringElementSolution {

    // Brute Force
    public int brute(int[] arr) {
        int maxFreq = 0, ans = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) count++;
            }
            if (count > maxFreq) {
                maxFreq = count;
                ans = arr[i];
            }
        }
        return ans;
    }

    // Better
    public int better(int[] arr) {
        Arrays.sort(arr);
        int maxFreq = 1, ans = arr[0], count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                if (count > maxFreq) {
                    maxFreq = count;
                    ans = arr[i - 1];
                }
                count = 1;
            }
        }
        if (count > maxFreq) ans = arr[arr.length - 1];
        return ans;
    }

    // Optimal
    public int optimal(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0, ans = arr[0];
        for (int num : arr) {
            int count = freq.getOrDefault(num, 0) + 1;
            freq.put(num, count);
            if (count > maxFreq) {
                maxFreq = count;
                ans = num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        HighestOccurringElementSolution sol = new HighestOccurringElementSolution();
        int[] arr = {1, 2, 2, 3, 1, 4, 2};

        System.out.println("Brute: " + sol.brute(arr));
        System.out.println("Better: " + sol.better(arr));
        System.out.println("Optimal: " + sol.optimal(arr));
    }
}
