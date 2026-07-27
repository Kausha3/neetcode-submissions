class Solution {
    public int maxProfit(int[] prices) {
        return recursion(prices, 0, 1);
    }
    private int recursion(int[] prices, int index, int buy) {
        if (index >= prices.length) {
            return 0;
        }
        int profit = 0;
        if (buy == 1) {
            profit += Math.max(-prices[index] + recursion(prices, index + 1, 0), recursion(prices, index + 1, 1));
        }
        else {
            profit += Math.max(prices[index] + recursion(prices, index + 2, 1), recursion(prices, index + 1, 0));
        }

        return profit;
    }
}
