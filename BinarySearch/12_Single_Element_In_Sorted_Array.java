// Problem: Search Single Element in a Sorted Array
// Every element appears twice except one. Find that single element.

// Brute Force Approach:
// - Use XOR: a ^ a = 0, and 0 ^ b = b
// - XOR all elements → result is the single element
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Better Approach:
// - Check pairs linearly: arr[i] != arr[i+1] → single element
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Optimal Approach:
// - Use binary search on index parity
// - If mid is even:
//      - If arr[mid] == arr[mid+1], single is on right
//      - Else, single is on left
// - If mid is odd:
//      - If arr[mid] == arr[mid-1], single is on right
//      - Else, single is on left
// - Time Complexity: O(log n)
// - Space Complexity: O(1)

public class Solution {

    // -------------------------
    // Brute Force (XOR)
    // -------------------------
    public int brute(int[] arr) {
        int xor = 0;
        for (int num : arr) xor ^= num;
        return xor;
    }

    // -------------------------
    // Better Approach (Linear Scan)
    // -------------------------
    public int better(int[] arr) {
        int n = arr.length;

        // Check pairs
        for (int i = 0; i < n - 1; i += 2) {
            if (arr[i] != arr[i + 1]) {
                return arr[i];
            }
        }

        // If not found in pairs, last element is single
        return arr[n - 1];
    }

    // -------------------------
    // Optimal Approach (Binary Search)
    // -------------------------
    public int optimal(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Ensure mid is even
            if (mid % 2 == 1) mid--;

            // If pair is correct → single is on right
            if (arr[mid] == arr[mid + 1]) {
                low = mid + 2;
            }
            // Pair is broken → single is on left
            else {
                high = mid;
            }
        }

        return arr[low]; // low == high → single element
    }

    // -------------------------
    // Main (Optional for testing)
    // -------------------------
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1,1,2,2,3,3,4,5,5,6,6};
        int[] arr2 = {1,1,3,5,5};

        System.out.println(sol.brute(arr1));   // 4
        System.out.println(sol.better(arr1));  // 4
        System.out.println(sol.optimal(arr1)); // 4

        System.out.println(sol.brute(arr2));   // 3
        System.out.println(sol.better(arr2));  // 3
        System.out.println(sol.optimal(arr2)); // 3
    }
}
