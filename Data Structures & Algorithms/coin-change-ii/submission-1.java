class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return recursion(amount, coins, 0, dp);
    }

    private int recursion(int amount, int[] coins, int index, int[][] dp) {
        if (index >= coins.length) {
            if (amount != 0 ) return 0;
        }
        if (amount == 0) {
            return 1;
        }
        if (dp[index][amount] != -1) return dp[index][amount];
        int count = recursion(amount, coins, index + 1, dp);
        if (coins[index] <= amount) {
            count += recursion(amount - coins[index], coins, index, dp);
        }
        return dp[index][amount] = count;
    }
}
