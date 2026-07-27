class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int zeroStart = recursion(0, cost, n);
        int oneStart = recursion(1, cost, n);
        return Math.min(zeroStart, oneStart);
    }

    private int recursion(int start, int[] cost, int end) {
        if (start >= end) {
            return 0;
        }
        int oneStep = recursion(start + 1, cost, end);
        int twoStep = recursion(start + 2, cost, end);

        return cost[start] + Math.min(oneStep, twoStep);
    }
}
