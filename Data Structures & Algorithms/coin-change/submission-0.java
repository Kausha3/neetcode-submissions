class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] countCoins = {Integer.MAX_VALUE};
        recursion(coins, amount, 0, countCoins, 0);
       return countCoins[0] == Integer.MAX_VALUE ? -1: countCoins[0];
    }

    private void recursion(int[] coins, int amount, int index, int[] countCoins, int count) {
        if (amount == 0) {
            countCoins[0] = Math.min(countCoins[0], count);
            return;
        }
        if (index >= coins.length) {
            return;
        }
        if (coins[index] > amount) {
            return;
        }
        recursion(coins, amount - coins[index], index, countCoins, count + 1);
        recursion(coins, amount, index + 1, countCoins, count);
    }
}
