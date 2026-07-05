// Problem: Find the Majority Element that occurs more than N/2 times

// Brute Force Approach:
// - For each element, count its frequency by scanning the array
// - If frequency > n/2, return that element
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach (HashMap):
// - Use a HashMap to store frequencies of each element
// - Traverse the array and update counts
// - Return the element with frequency > n/2
// - Time Complexity: O(n)
// - Space Complexity: O(n)

// Optimal Approach (Moore’s Voting Algorithm):
// - Maintain a candidate and a counter
// - Traverse the array:
//   - If counter = 0, set candidate = current element
//   - If current element == candidate, increment counter
//   - Else, decrement counter
// - Candidate will be the majority element (guaranteed by problem statement)
// - Time Complexity: O(n)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public int brute(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) count++;
            }
            if (count > n / 2) return nums[i];
        }
        return -1; // not expected since majority element is guaranteed
    }

    // Better (HashMap)
    public int better(int[] nums) {
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n / 2) return num;
        }
        return -1; // not expected
    }

    // Optimal (Moore’s Voting Algorithm)
    public int optimal(int[] nums) {
        int candidate = 0, count = 0;

        // Phase 1: Find candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Candidate is guaranteed majority by problem statement
        return candidate;
    }
}
