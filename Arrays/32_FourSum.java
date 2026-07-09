// Problem: 4 Sum | Find Quads that add up to a target value

// Brute Force Approach:
// - Use four nested loops to pick every possible quadruplet (a, b, c, d)
// - Check if arr[a] + arr[b] + arr[c] + arr[d] == target
// - Sort each valid quadruplet and store it in a Set to avoid duplicates
// - Time Complexity: O(n^4 log n)  -> n^4 for loops, log n for sorting each quad / set insertion
// - Space Complexity: O(k * 4) for storing k unique quadruplets (+ set overhead)

// Better Approach (Three Loops + HashSet):
// - Fix three elements (a, b, c) using three nested loops
// - Use a HashSet to check if the required 4th element (target - sum of first 3) exists
//   in the remaining part of the array in O(1) average time
// - Sort each valid quadruplet and store it in a Set to avoid duplicates
// - Time Complexity: O(n^3) average (due to HashSet lookups), O(n^3 log n) if quad sorting counted
// - Space Complexity: O(n) for HashSet + O(k * 4) for storing unique quadruplets

// Optimal Approach (Sorting + Two Pointers):
// - Sort the array first
// - Fix the first two elements using two nested loops (i and j)
// - Use two pointers (left, right) on the remaining part to find pairs that
//   complete the sum to target, moving pointers based on comparison
// - Skip duplicate elements at every level (i, j, left, right) to ensure uniqueness
// - Time Complexity: O(n^3)
// - Space Complexity: O(1) (excluding the space used to store the answer)
import java.util.*;

class Solution {
    // Brute Force
    public List<List<Integer>> brute(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> resultSet = new HashSet<>();

        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    for (int d = c + 1; d < n; d++) {
                        long sum = (long) arr[a] + arr[b] + arr[c] + arr[d];
                        if (sum == target) {
                            List<Integer> quad = Arrays.asList(arr[a], arr[b], arr[c], arr[d]);
                            Collections.sort(quad);
                            resultSet.add(quad);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(resultSet);
    }

    // Better (Three Loops + HashSet)
    public List<List<Integer>> better(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> resultSet = new HashSet<>();

        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                Set<Long> seen = new HashSet<>();
                for (int c = b + 1; c < n; c++) {
                    long sumOfThree = (long) arr[a] + arr[b] + arr[c];
                    long fourth = target - sumOfThree;

                    if (seen.contains(fourth)) {
                        List<Integer> quad = Arrays.asList(arr[a], arr[b], arr[c], (int) fourth);
                        Collections.sort(quad);
                        resultSet.add(quad);
                    }
                    seen.add((long) arr[c]);
                }
            }
        }
        return new ArrayList<>(resultSet);
    }

    // Optimal (Sorting + Two Pointers)
    public List<List<Integer>> optimal(int[] arr, int target) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // skip duplicate for i
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            for (int j = i + 1; j < n; j++) {
                // skip duplicate for j
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];

                    if (sum == target) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;
                        // skip duplicates for left and right
                        while (left < right && arr[left] == arr[left - 1]) left++;
                        while (left < right && arr[right] == arr[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    // Helper to print list of quadruplets
    private static void printResult(List<List<Integer>> quads) {
        System.out.println(quads);
    }

    // Test main
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 0, -1, 0, -2, 2};
        int target1 = 0;

        int[] arr2 = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target2 = 9;

        System.out.print("Brute (arr1):   ");
        printResult(sol.brute(arr1.clone(), target1));
        System.out.print("Better (arr1):  ");
        printResult(sol.better(arr1.clone(), target1));
        System.out.print("Optimal (arr1): ");
        printResult(sol.optimal(arr1.clone(), target1));

        System.out.print("Brute (arr2):   ");
        printResult(sol.brute(arr2.clone(), target2));
        System.out.print("Better (arr2):  ");
        printResult(sol.better(arr2.clone(), target2));
        System.out.print("Optimal (arr2): ");
        printResult(sol.optimal(arr2.clone(), target2));
    }
}
