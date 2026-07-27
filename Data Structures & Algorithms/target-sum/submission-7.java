class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int arrSum = 0;
        for (int i = 0; i < nums.length; i++) {
            arrSum += nums[i];
        }
        if ((target + arrSum) % 2 != 0 || target > arrSum) return 0;
        int targetSum = (arrSum + target) / 2 ;
        return recursion (nums, targetSum, 0);
    }

    private int recursion(int[] nums, int targetSum, int index) {
        if (index >= nums.length) {
            return targetSum == 0 ? 1 : 0;
        }

        int totalCount = recursion(nums, targetSum - nums[index], index + 1) +
        recursion(nums, targetSum , index + 1);
        return totalCount;
    }


}
