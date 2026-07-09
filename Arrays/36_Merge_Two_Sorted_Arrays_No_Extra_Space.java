// Problem: Merge Two Sorted Arrays Without Extra Space

// nums1 has length m + n (first m elements are actual data, rest are trailing 0s)
// nums2 has length n (all actual data)
// Merge both into nums1 in-place, sorted in non-decreasing order.
//
// Brute Force Approach (Using Extra Space):
// - Copy the first m elements of nums1 and all n elements of nums2 into a
//   temporary array of size (m + n)
// - Sort the temporary array
// - Copy the sorted temporary array back into nums1
// - Time Complexity: O((m+n) log(m+n)) for sorting
// - Space Complexity: O(m+n) for the temporary array
//
// Optimal Approach (Three Pointers, Fill from the Back - No Extra Space):
// - Since nums1 has empty slots (0s) at the end, we can merge from the BACK
//   instead of the front, so we never overwrite data we still need to read
// - Use three pointers:
//     i -> last actual element of nums1 (index m - 1)
//     j -> last element of nums2 (index n - 1)
//     k -> last index of nums1 (index m + n - 1), where the next largest
//          element should be placed
// - Compare nums1[i] and nums2[j]; place the larger one at nums1[k], then
//   move the corresponding pointer(s) backward
// - Continue until all elements of nums2 have been placed (remaining nums1
//   elements are already in their correct position)
// - Time Complexity: O(m + n)
// - Space Complexity: O(1)
//
// Alternate Optimal Approach (Gap Method - Shell Sort based, No Extra Space):
// - Treat nums1's first m elements and nums2's n elements as one CONCEPTUAL
//   combined array of size (m+n), without physically merging them
// - Start with gap = ceil((m+n) / 2)
// - Compare elements that are "gap" apart in this conceptual array (an index
//   < m maps to nums1[index], an index >= m maps to nums2[index - m]);
//   swap them if the left one is bigger than the right one
// - After scanning all pairs at the current gap, shrink gap = ceil(gap / 2)
// - Repeat until gap becomes 0 (the last round always uses gap = 1)
// - This is essentially Shell Sort's gap-based comparison/swap idea applied
//   across the seam of the two arrays, so no extra array is ever allocated
// - Time Complexity: O((m+n) log(m+n))
// - Space Complexity: O(1)

import java.util.*;

class Solution {
    // Brute Force (Using Extra Space)
    public void brute(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];

        // copy actual elements of nums1 (first m) and all of nums2
        for (int i = 0; i < m; i++) temp[i] = nums1[i];
        for (int j = 0; j < n; j++) temp[m + j] = nums2[j];

        Arrays.sort(temp);

        // copy back into nums1
        for (int i = 0; i < m + n; i++) nums1[i] = temp[i];
    }

    // Optimal (Three Pointers, Fill from the Back)
    public void optimal(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // last actual element in nums1
        int j = n - 1;       // last element in nums2
        int k = m + n - 1;   // last index of nums1 (where to place next largest)

        // place elements from the back, largest first
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        // if any nums1 elements remain (i >= 0), they are already in
        // correct position, so nothing more needs to be done
    }

    // Alternate Optimal (Gap Method - Shell Sort based)
    public void optimalGapMethod(int[] nums1, int m, int[] nums2, int n) {
        int total = m + n;
        int gap = (total + 1) / 2; // initial gap = ceil(total / 2)

        while (gap > 0) {
            int i = 0;
            int j = gap;
            while (j < total) {
                int valI = get(nums1, m, nums2, i);
                int valJ = get(nums1, m, nums2, j);
                if (valI > valJ) {
                    set(nums1, m, nums2, i, valJ);
                    set(nums1, m, nums2, j, valI);
                }
                i++;
                j++;
            }
            if (gap == 1) break;
            gap = (gap + 1) / 2; // shrink gap, rounding up
        }
    }

    // Helper: read the value at a conceptual index across nums1 (first m) + nums2
    private int get(int[] nums1, int m, int[] nums2, int index) {
        return index < m ? nums1[index] : nums2[index - m];
    }

    // Helper: write the value at a conceptual index across nums1 (first m) + nums2
    private void set(int[] nums1, int m, int[] nums2, int index, int value) {
        if (index < m) nums1[index] = value;
        else nums2[index - m] = value;
    }

    // Test main
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1a = {-5, -2, 4, 5, 0, 0, 0};
        int[] nums2a = {-3, 1, 8};
        int[] nums1b = nums1a.clone();

        int[] nums1c = {0, 2, 7, 8, 0, 0, 0};
        int[] nums2c = {-7, -3, -1};
        int[] nums1d = nums1c.clone();

        sol.brute(nums1a, 4, nums2a, 3);
        System.out.println("Brute (nums1a):   " + Arrays.toString(nums1a));

        sol.optimal(nums1b, 4, nums2a.clone(), 3);
        System.out.println("Optimal (nums1b): " + Arrays.toString(nums1b));

        // gap method: pass the first m elements of nums1 (real data only) and
        // nums2 separately; then rebuild the full padded nums1 array for printing
        int[] arr1e = Arrays.copyOfRange(nums1a.clone(), 0, 4); // fresh real data
        int[] arr2e = {-3, 1, 8};
        sol.optimalGapMethod(arr1e, 4, arr2e, 3);
        int[] merged1 = new int[7];
        System.arraycopy(arr1e, 0, merged1, 0, 4);
        System.arraycopy(arr2e, 0, merged1, 4, 3);
        System.out.println("GapMethod (set1): " + Arrays.toString(merged1));

        sol.brute(nums1c, 4, nums2c, 3);
        System.out.println("Brute (nums1c):   " + Arrays.toString(nums1c));

        sol.optimal(nums1d, 4, nums2c.clone(), 3);
        System.out.println("Optimal (nums1d): " + Arrays.toString(nums1d));

        int[] arr1f = {0, 2, 7, 8};
        int[] arr2f = {-7, -3, -1};
        sol.optimalGapMethod(arr1f, 4, arr2f, 3);
        int[] merged2 = new int[7];
        System.arraycopy(arr1f, 0, merged2, 0, 4);
        System.arraycopy(arr2f, 0, merged2, 4, 3);
        System.out.println("GapMethod (set2): " + Arrays.toString(merged2));
    }
}
