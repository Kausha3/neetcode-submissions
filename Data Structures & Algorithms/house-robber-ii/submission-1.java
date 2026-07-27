class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        int first = recursion(nums, 0, nums.length - 2, dp);

        Arrays.fill(dp, -1);
        int second = recursion(nums, 1, nums.length - 1, dp);
        return Math.max(first, second);
    }

    private int recursion (int[] nums, int index, int end, int[] dp) {
        if (index > end) {
            return 0;
        }
        if (dp[index] != -1) return dp[index];

        int take = nums[index] + recursion (nums, index + 2, end, dp);
        int skip = recursion (nums, index + 1, end, dp);

        return dp[index] = Math.max(take, skip);

    }
}
