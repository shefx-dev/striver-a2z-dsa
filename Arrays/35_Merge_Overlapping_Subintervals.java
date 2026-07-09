// Problem: Merge Overlapping Sub-intervals

// Brute Force Approach:
// - Sort the intervals by their starting point
// - For each interval (that hasn't been merged yet), keep extending its end
//   by scanning through all other intervals that overlap with the current merged range
// - Mark intervals as visited once merged, so they aren't processed again
// - Time Complexity: O(n log n) for sorting + O(n^2) for merging = O(n^2)
// - Space Complexity: O(n) for the visited array + O(n) for storing the result

// Optimal Approach (Sort + Single Pass):
// - Sort the intervals by their starting point
// - Traverse the sorted intervals, maintaining a "current" merged interval
// - If the next interval's start <= current interval's end, they overlap ->
//   extend current's end to max(current.end, next.end)
// - Otherwise, push the current interval to the result and start a new current interval
// - Time Complexity: O(n log n) for sorting + O(n) for the single pass = O(n log n)
// - Space Complexity: O(n) for storing the result (ignoring sort's internal space)

// Optimal Approach - Alternate Style (Sort + For loop with inner While loop):
// - Sort the intervals by their starting point
// - For each unmerged interval i, use a WHILE loop to keep absorbing the next
//   interval as long as it overlaps (intervals[j+1][0] <= mergedEnd)
// - This advances an inner pointer j past every interval that gets merged,
//   then the outer for loop jumps straight to i = j + 1 (no re-checking merged ones)
// - Same O(n log n) complexity as the single-pass version above -> this is just
//   a different (pointer-skipping) way of writing the same optimal idea
// - Time Complexity: O(n log n) for sorting + O(n) for the pass = O(n log n)
// - Space Complexity: O(n) for storing the result

import java.util.*;

class Solution {
    // Brute Force
    public List<int[]> brute(int[][] intervals) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        if (n == 0) return result;

        // sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int start = intervals[i][0];
            int end = intervals[i][1];
            visited[i] = true;

            // keep scanning to extend the current merged interval
            for (int j = i + 1; j < n; j++) {
                if (visited[j]) continue;
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                    visited[j] = true;
                }
            }
            result.add(new int[]{start, end});
        }
        return result;
    }

    // Optimal (Sort + Single Pass)
    public List<int[]> optimal(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        if (n == 0) return result;

        // sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] <= end) {
                // overlapping -> extend the end
                end = Math.max(end, intervals[i][1]);
            } else {
                // no overlap -> push current and start a new one
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new int[]{start, end}); // add the last merged interval
        return result;
    }

    // Optimal - Alternate Style (Sort + For loop with inner While loop)
    public List<int[]> optimalForWhile(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        if (n == 0) return result;

        // sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            int mergedStart = intervals[i][0];
            int mergedEnd = intervals[i][1];
            int j = i;

            // keep absorbing the next interval as long as it overlaps
            while (j + 1 < n && intervals[j + 1][0] <= mergedEnd) {
                mergedEnd = Math.max(mergedEnd, intervals[j + 1][1]);
                j++;
            }

            result.add(new int[]{mergedStart, mergedEnd});
            i = j; // jump outer loop past everything already merged
        }
        return result;
    }

    // Helper to print list of intervals
    private static void printResult(List<int[]> intervals) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < intervals.size(); i++) {
            sb.append(Arrays.toString(intervals.get(i)));
            if (i != intervals.size() - 1) sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    // Test main
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals2 = {{1, 4}, {4, 5}};

        System.out.print("Brute (intervals1):   ");
        printResult(sol.brute(clone(intervals1)));
        System.out.print("Optimal (intervals1): ");
        printResult(sol.optimal(clone(intervals1)));
        System.out.print("OptimalForWhile (intervals1): ");
        printResult(sol.optimalForWhile(clone(intervals1)));

        System.out.print("Brute (intervals2):   ");
        printResult(sol.brute(clone(intervals2)));
        System.out.print("Optimal (intervals2): ");
        printResult(sol.optimal(clone(intervals2)));
        System.out.print("OptimalForWhile (intervals2): ");
        printResult(sol.optimalForWhile(clone(intervals2)));
    }

    // deep-clone helper so both methods get a fresh 2D array (since sort mutates input)
    private static int[][] clone(int[][] arr) {
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i].clone();
        }
        return copy;
    }
}
