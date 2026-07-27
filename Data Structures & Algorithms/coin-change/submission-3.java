class Solution {
    public int coinChange(int[] coins, int amount) {
        int res = recursion(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int recursion(int[] coins, int amount, int index) {
        if (index >= coins.length) {
            if (amount == 0) {
                return 0; 
            }
            return Integer.MAX_VALUE;
        }
        int take = Integer.MAX_VALUE;
        int notTake = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            int res = recursion(coins, amount - coins[index],index);
            if (res != Integer.MAX_VALUE) {
                 take = 1 + res;
            }
            notTake = recursion(coins, amount, index + 1);
        }
        else {
            notTake = recursion(coins, amount, index + 1);
        }

        return Math.min(take, notTake);
    }
}
