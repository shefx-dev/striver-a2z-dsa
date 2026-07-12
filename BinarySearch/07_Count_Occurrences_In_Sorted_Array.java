// Problem: Count Occurrences in Sorted Array

// Brute Force Approach:
// - Traverse the array linearly
// - Count how many times target appears
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Better Approach:
// - Use Arrays.binarySearch() to find one occurrence
// - Then expand left and right to count duplicates
// - Time Complexity: O(log n + k), where k is number of duplicates
// - Space Complexity: O(1)

// Optimal Approach:
// - Use modified binary search twice
//   -> First to find the first occurrence of target
//   -> Second to find the last occurrence of target
// - Count = (lastIndex - firstIndex + 1)
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

import java.util.Arrays;

class Solution {

    // Brute Force
    public int brute(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) count++;
        }
        return count;
    }

    // Better
    public int better(int[] nums, int target) {
        int idx = Arrays.binarySearch(nums, target);
        if (idx < 0) return 0;
        int count = 1;
        int left = idx - 1, right = idx + 1;
        while (left >= 0 && nums[left] == target) {
            count++;
            left--;
        }
        while (right < nums.length && nums[right] == target) {
            count++;
            right++;
        }
        return count;
    }

    // Optimal
    public int optimal(int[] nums, int target) {
        int first = firstOccurrence(nums, target);
        if (first == -1) return 0;
        int last = lastOccurrence(nums, target);
        return last - first + 1;
    }

    private int firstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                result = mid;
                high = mid - 1; // move left
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private int lastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1, result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                result = mid;
                low = mid + 1; // move right
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
