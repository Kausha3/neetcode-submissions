class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return recursion(nums, 0, dp);
    }

    private int recursion(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1) return dp[index];

        int rob = nums[index] + recursion(nums, index + 2, dp);
        int skip = recursion(nums, index + 1, dp);

        return dp[index] = Math.max(rob, skip);
    }
}
