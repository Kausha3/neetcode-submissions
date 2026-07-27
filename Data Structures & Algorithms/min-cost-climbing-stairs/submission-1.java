class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        int zeroStart = recursion(0, cost, dp);
        int oneStart = recursion(1, cost, dp);
        return Math.min(zeroStart, oneStart);
    }

    private int recursion(int start, int[] cost, int[] dp) {
        if (start >= cost.length) {
            return 0;
        }
        if (dp[start] != -1) return dp[start];
        int oneStep = recursion(start + 1, cost, dp);
        int twoStep = recursion(start + 2, cost, dp);

        return dp[start] = cost[start] + Math.min(oneStep, twoStep);
    }
}
