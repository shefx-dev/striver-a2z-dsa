// Problem: Stock Buy And Sell (Single Transaction)

// Brute Force Approach:
// - For each day, try buying at that day
// - For each later day, try selling and calculate profit
// - Track the maximum profit
// - Time Complexity: O(n^2)
// - Space Complexity: O(1)

// Better Approach (Prefix Minimum):
// - Keep track of the minimum price seen so far
// - For each day, calculate profit = currentPrice - minPrice
// - Update maxProfit if profit is larger
// - Time Complexity: O(n)
// - Space Complexity: O(1)

// Optimal Approach (Same as Better, simplified):
// - Traverse once, maintain minPrice and maxProfit
// - Update minPrice when a lower price is found
// - Update maxProfit when a higher profit is found
// - Time Complexity: O(n)
// - Space Complexity: O(1)

class Solution {

    // Brute Force
    public int brute(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    // Better
    public int better(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    // Optimal (same as Better)
    public int optimal(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
