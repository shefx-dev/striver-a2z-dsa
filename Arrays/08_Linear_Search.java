// Problem: Linear Search (Find First Occurrence)

// Brute Force Approach:
// - Traverse the array using nested loops (unnecessary but brute-style)
// - For each element, compare with target
// - Return the first index where target is found
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach:
// - Single loop through the array
// - Return the index as soon as target is found
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Optimal Approach:
// - Same as Better (linear search is already optimal for unsorted arrays)
// - Time Complexity: O(n)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public int brute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            // unnecessary inner loop to simulate brute force
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    return j;
                }
            }
        }
        return -1;
    }

    // Better
    public int better(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Optimal
    public int optimal(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) {
          return -1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
