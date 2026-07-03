// Problem: Union of Two Sorted Arrays

// Brute Force Approach:
// - Concatenate both arrays into a list
// - Remove duplicates manually using nested loops
// - Sort the final array before returning
// - Time Complexity: O((n+m)^2) + O((n+m) log(n+m))
// - Space Complexity: O(n+m)

// Better Approach (Two Pointers):
// - Since arrays are sorted, use two pointers to merge like merge-sort
// - Skip duplicates by checking the last inserted element
// - Time Complexity: O(n+m)
// - Space Complexity: O(n+m)

// Optimal Approach (TreeSet):
// - Insert all elements into a TreeSet (removes duplicates and keeps sorted order)
// - Convert TreeSet to int[]
// - Time Complexity: O((n+m) log(n+m))
// - Space Complexity: O(n+m)

import java.util.*;

class Solution {

    // Brute Force
    public int[] brute(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) list.add(i);
        for (int i : nums2) list.add(i);

        List<Integer> unionList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (list.get(i).equals(list.get(j))) {
                    found = true;
                    break;
                }
            }
            if (!found) unionList.add(list.get(i));
        }

        int[] arr = new int[unionList.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = unionList.get(i);

        Arrays.sort(arr); // ensure ascending order
        return arr;
    }

    // Better (Two Pointers)
    public int[] better(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        List<Integer> unionList = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                addIfNotPresent(unionList, nums1[i++]);
            } else if (nums2[j] < nums1[i]) {
                addIfNotPresent(unionList, nums2[j++]);
            } else {
                addIfNotPresent(unionList, nums1[i]);
                i++; j++;
            }
        }
        while (i < nums1.length) addIfNotPresent(unionList, nums1[i++]);
        while (j < nums2.length) addIfNotPresent(unionList, nums2[j++]);

        int[] arr = new int[unionList.size()];
        for (int k = 0; k < unionList.size(); k++) arr[k] = unionList.get(k);

        return arr;
    }

    private void addIfNotPresent(List<Integer> list, int val) {
        if (list.isEmpty() || list.get(list.size() - 1) != val) {
            list.add(val);
        }
    }

    // Optimal (TreeSet)
    public int[] optimal(int[] nums1, int[] nums2) {
        Set<Integer> unionSet = new TreeSet<>();
        for (int i : nums1) unionSet.add(i);
        for (int i : nums2) unionSet.add(i);

        int[] arr = new int[unionSet.size()];
        int idx = 0;
        for (int val : unionSet) arr[idx++] = val;

        return arr;
    }

    // Test main
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3, 4, 6, 7, 9, 9};
        int[] nums2 = {1, 5, 7, 8, 8};

        System.out.println("Brute:   " + Arrays.toString(sol.brute(nums1, nums2)));
        System.out.println("Better:  " + Arrays.toString(sol.better(nums1, nums2)));
        System.out.println("Optimal: " + Arrays.toString(sol.optimal(nums1, nums2)));
    }
}

