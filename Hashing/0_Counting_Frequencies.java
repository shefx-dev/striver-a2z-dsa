// Problem: Counting Frequencies of Array Elements

// Brute Force Approach:
// - For each element, scan the entire array to count its frequency
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach:
// - Sort the array, then count consecutive duplicates
// - Time Complexity: O(n log n)
// - Space Complexity: O(1) (if in-place sort)

// Optimal Approach:
// - Use a HashMap to store frequencies directly
// - Time Complexity: O(n)
// - Space Complexity: O(n)

import java.util.*;

class CountingFrequenciesSolution {

    // Brute Force
    public void brute(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) count++;
            }
            System.out.println(arr[i] + " -> " + count);
        }
    }

    // Better
    public void better(int[] arr) {
        Arrays.sort(arr);
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                System.out.println(arr[i - 1] + " -> " + count);
                count = 1;
            }
        }
        System.out.println(arr[arr.length - 1] + " -> " + count);
    }

    // Optimal
    public void optimal(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        CountingFrequenciesSolution sol = new CountingFrequenciesSolution();
        int[] arr = {1, 2, 2, 3, 1, 4};

        System.out.println("Brute:");
        sol.brute(arr);

        System.out.println("Better:");
        sol.better(arr);

        System.out.println("Optimal:");
        sol.optimal(arr);
    }
}
