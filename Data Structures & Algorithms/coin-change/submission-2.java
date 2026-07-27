class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = recursion(coins, amount, 0, 0, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int recursion(int[] coins, int amount, int index, int count, int minCoins) {
        if (index >= coins.length) {
            if (amount == 0) {
                return count; 
            }
            return Integer.MAX_VALUE;
        }
        int take = Integer.MAX_VALUE;
        int notTake = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            take = recursion(coins, amount - coins[index],index, count + 1,minCoins);
            notTake = recursion(coins, amount, index + 1, count, minCoins);
        }
        else {
            notTake = recursion(coins, amount, index + 1, count, minCoins);
        }

        return Math.min(take, notTake);
    }
}
