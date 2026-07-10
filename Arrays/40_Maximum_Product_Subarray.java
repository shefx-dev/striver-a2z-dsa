// Problem: Maximum Product Subarray in an Array
// Definition: Given an array that contains both negative and positive integers,
// find the maximum product subarray.

// Brute Force Approach:
// - For every subarray [i..j], compute the product from scratch
// - Track the maximum product seen
// - Time Complexity: O(n^3)
// - Space Complexity: O(1)

// Better Approach (Nested Loop with Running Product):
// - For each starting index i, compute product incrementally for subarray [i..j]
// - Reset product when encountering zero
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Optimal Approach (Dynamic Programming):
// - Maintain two variables while traversing: maxProd and minProd
// - At each index, compute currentMax = max(nums[i], nums[i]*maxProd, nums[i]*minProd)
// - Similarly compute currentMin = min(nums[i], nums[i]*maxProd, nums[i]*minProd)
// - Update global answer with currentMax
// - This works because a negative number can flip minProd into maxProd
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Optimal Approach (Prefix–Suffix Trick):
// - Maintain prefix product (from left) and suffix product (from right)
// - Reset product to 1 when encountering zero
// - At each step, update answer with max(prefix, suffix)
// - Time Complexity: O(n)
// - Space Complexity: O(1)

class Solution {
    // Brute Force
    public int brute(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int product = 1;
                for (int k = i; k <= j; k++) {
                    product *= nums[k];
                }
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    // Better (Nested Loop with Running Product)
    public int better(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
                if (nums[j] == 0) product = 1; // reset on zero
            }
        }
        return maxProduct;
    }

    // Optimal (Dynamic Programming)
    public int optimalDP(int[] nums) {
        int n = nums.length;
        int maxProd = nums[0];
        int minProd = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int tempMax = Math.max(nums[i], Math.max(nums[i] * maxProd, nums[i] * minProd));
            int tempMin = Math.min(nums[i], Math.min(nums[i] * maxProd, nums[i] * minProd));
            maxProd = tempMax;
            minProd = tempMin;
            ans = Math.max(ans, maxProd);
        }
        return ans;
    }

    // Optimal (Prefix–Suffix Trick)
    public int optimalPrefixSuffix(int[] nums) {
        int n = nums.length;
        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;

            pre *= nums[i];          // prefix product
            suff *= nums[n - i - 1]; // suffix product

            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }

    // Test main
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1,2,3,4,5,0};
        int[] nums2 = {1,2,-3,0,-4,-5};

        System.out.println("Brute (nums1):   " + sol.brute(nums1));            // 120
        System.out.println("Better (nums1):  " + sol.better(nums1));           // 120
        System.out.println("OptimalDP (nums1): " + sol.optimalDP(nums1));      // 120
        System.out.println("OptimalPrefixSuffix (nums1): " + sol.optimalPrefixSuffix(nums1)); // 120

        System.out.println("Brute (nums2):   " + sol.brute(nums2));            // 20
        System.out.println("Better (nums2):  " + sol.better(nums2));           // 20
        System.out.println("OptimalDP (nums2): " + sol.optimalDP(nums2));      // 20
        System.out.println("OptimalPrefixSuffix (nums2): " + sol.optimalPrefixSuffix(nums2)); // 20
    }
}
