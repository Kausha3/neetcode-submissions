class Solution {
    public int maxProfit(int[] prices) {
        return recursion(prices, 0, true);
    }
    private int recursion(int[] prices, int index, boolean buy) {
        if (index >= prices.length) {
            return 0;
        }
        int profit = 0;
        if (buy) {
            profit += Math.max(-prices[index] + recursion(prices, index + 1, false), recursion(prices, index + 1, true));
        }
        else {
            profit += Math.max(prices[index] + recursion(prices, index + 2, true), recursion(prices, index + 1, false));
        }

        return profit;
    }
}
