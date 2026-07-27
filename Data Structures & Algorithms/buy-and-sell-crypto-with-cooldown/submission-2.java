class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return recursion(prices, 0, 1, dp);
    }
    private int recursion(int[] prices, int index, int buy, int[][] dp) {
        if (index >= prices.length) {
            return 0;
        }
        if (dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if (buy == 1) {
            profit += Math.max(-prices[index] + recursion(prices, index + 1, 0, dp), recursion(prices, index + 1, 1, dp));
        }
        else {
            profit += Math.max(prices[index] + recursion(prices, index + 2, 1, dp), recursion(prices, index + 1, 0, dp));
        }

        return dp[index][buy] = profit;
    }
}
