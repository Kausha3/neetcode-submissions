class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int result =  recursion(n, dp);
        return result;
    }

    private int recursion(int index, int[] dp) {
        if (index == 0 || index == 1) {
            return 1;
        }
        if (dp[index] != -1) return dp[index];
        return dp[index] = recursion(index - 1, dp) + recursion(index - 2, dp);
    }
}
