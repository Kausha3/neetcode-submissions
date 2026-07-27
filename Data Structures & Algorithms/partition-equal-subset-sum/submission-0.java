class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        boolean ans = recursion(nums, sum/2, 0, 0);
        return ans;
    }

    private boolean recursion(int[] nums, int target, int index, int sum2) {
        if (index >= nums.length) {
            return false;
        }
        if (sum2 == target) {
            return true;
        }

        recursion(nums, target, index + 1, sum2 + nums[index]);
        recursion(nums, target, index + 1, sum2);

        return recursion(nums, target, index + 1, sum2 + nums[index]) ||
        recursion(nums, target, index + 1, sum2);
    }
}
