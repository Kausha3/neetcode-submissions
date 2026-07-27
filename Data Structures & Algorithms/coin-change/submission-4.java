class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int res = recursion(coins, amount, 0, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int recursion(int[] coins, int amount, int index, int[][] dp) {
        if (index >= coins.length) {
            if (amount == 0) {
                return 0; 
            }
            return Integer.MAX_VALUE;
        }
        if (dp[index][amount] != -1) return dp[index][amount];

        int take = Integer.MAX_VALUE;
        int notTake = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            int res = recursion(coins, amount - coins[index],index, dp);
            if (res != Integer.MAX_VALUE) {
                 take = 1 + res;
            }
            notTake = recursion(coins, amount, index + 1, dp);
        }
        else {
            notTake = recursion(coins, amount, index + 1, dp);
        }

        return dp[index][amount] = Math.min(take, notTake);
    }
}
