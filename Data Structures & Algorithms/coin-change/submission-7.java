class Solution {
    public int coinChange(int[] capacities, int requiredCapacity) {
        if (requiredCapacity == 0) return 0;
        int[][] dp = new int[capacities.length][requiredCapacity + 1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        int ans = recurse(0, capacities, requiredCapacity, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int recurse(int index, int[] capacities, int target, int[][] dp) {
        if (index >= capacities.length) return Integer.MAX_VALUE;
        if (target == 0) { 
            return 0;
        }
        if (dp[index][target] != -1) return dp[index][target];
        int take = Integer.MAX_VALUE; int skip = Integer.MAX_VALUE;
        if (capacities[index] <= target) {
            int count = recurse(index, capacities, target-capacities[index], dp);
            if (count != Integer.MAX_VALUE) 
                take = 1 + count;
        }
        skip = recurse(index + 1, capacities, target, dp);
        return dp[index][target] = Math.min(take, skip);
    }
}
