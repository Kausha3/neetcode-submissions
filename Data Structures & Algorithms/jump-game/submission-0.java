class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;

        int maxLength = 0;

        for (int i = 0; i < length; i++) {
            if (i > maxLength) return false;
            maxLength = Math.max(maxLength, i + nums[i]);
        }
        return true;
    }
}
