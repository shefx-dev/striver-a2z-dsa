// Problem: Count inversions in an array using merge sort

// Brute Force Approach:
// - For every pair (i, j) with i < j, check if arr[i] > arr[j]
// - If true, increment inversion count
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach (Prefix Sum style is not applicable here):
// - Instead of recomputing sums, we can use a Binary Indexed Tree (Fenwick Tree) or Balanced BST
// - Insert elements one by one and count how many greater elements have already appeared
// - Time Complexity: O(n log n)
// - Space Complexity: O(n)

// Optimal Approach (Merge Sort):
// - Modify merge sort to count inversions during merging
// - While merging, if left[i] > right[j], then all remaining elements in left[i..mid] form inversions with right[j]
// - Add (mid - i + 1) to inversion count
// - Time Complexity: O(n log n)
// - Space Complexity: O(n)

class Solution {
    // Brute Force
    public long brute(int[] arr) {
        int n = arr.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Optimal (Merge Sort)
    public long optimal(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSortHelper(arr, temp, 0, n-1);
    }

    private long mergeSortHelper(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left)/2;
        long count = 0;
        count += mergeSortHelper(arr, temp, left, mid);
        count += mergeSortHelper(arr, temp, mid+1, right);
        count += merge(arr, temp, left, mid, right);
        return count;
    }

    private long merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int k = left; k <= right; k++) {
            temp[k] = arr[k];
        }
        int i = left, j = mid+1, k = left;
        long count = 0;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
                count += (mid - i + 1); // key line: count inversions
            }
        }
        while (i <= mid) arr[k++] = temp[i++];
        while (j <= right) arr[k++] = temp[j++];
        return count;
    }

    // Test main
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,4,3,2,1};
        int[] arr3 = {5,3,2,1,4};

        System.out.println("Brute (arr1):   " + sol.brute(arr1));   // 0
        System.out.println("Optimal (arr1): " + sol.optimal(arr1)); // 0

        System.out.println("Brute (arr2):   " + sol.brute(arr2));   // 10
        System.out.println("Optimal (arr2): " + sol.optimal(arr2)); // 10

        System.out.println("Brute (arr3):   " + sol.brute(arr3));   // 7
        System.out.println("Optimal (arr3): " + sol.optimal(arr3)); // 7
    }
}
