// Problem: Two Sum : Check if a pair with given sum exists in Array

// Brute Force Approach:
// - Traverse all pairs (i, j) and check if arr[i] + arr[j] == target
// - Return YES if found, else NO
// - For indices variant, return [i, j] if found, else [-1, -1]
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach (Hashing):
// - Use a HashSet/HashMap to store seen numbers
// - For each element, check if target - arr[i] exists in the set/map
// - Return YES if found, else NO
// - For indices variant, store value → index in map and return indices when found
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Optimal Approach (Two Pointers):
// - Sort the array and use two pointers (left, right)
// - If arr[left] + arr[right] == target, return YES
// - If sum < target, move left; if sum > target, move right
// - Works cleanly for YES/NO variant
// - For indices variant, need to store original indices before sorting
// - Time Complexity: O(n log n) due to sorting
// - Space Complexity: O(1) if in-place sort

import java.util.*;

class Solution {

    // Brute Force
    public String bruteCheck(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) return "YES";
            }
        }
        return "NO";
    }

    public int[] bruteIndices(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    // Better (Hashing)
    public String betterCheck(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) return "YES";
            set.add(num);
        }
        return "NO";
    }

    public int[] betterIndices(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    // Optimal (Two Pointers)
    public String optimalCheck(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return "YES";
            else if (sum < target) left++;
            else right--;
        }
        return "NO";
    }
}
