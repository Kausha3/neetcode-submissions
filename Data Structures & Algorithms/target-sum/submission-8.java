class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int arrSum = 0;
        for (int i = 0; i < nums.length; i++) {
            arrSum += nums[i];
        }
        if ((target + arrSum) % 2 != 0 || Math.abs(target) > arrSum) return 0;
        int targetSum = (arrSum + target) / 2 ;
        if (targetSum < 0) return 0;
        int[][] dp = new int[nums.length + 1][targetSum + 1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        
        return recursion (nums, targetSum, 0, dp);
    }

    private int recursion(int[] nums, int targetSum, int index, int[][] dp) {
        if (index >= nums.length) {
            return targetSum == 0 ? 1 : 0;
        }
        if (dp[index][targetSum] != -1) return dp[index][targetSum];

        int count = recursion(nums, targetSum , index + 1, dp);

        if (nums[index] <= targetSum) {
            count += recursion(nums, targetSum - nums[index], index + 1, dp);
        }
        return dp[index][targetSum] = count;
    }


}
