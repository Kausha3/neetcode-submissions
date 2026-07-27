class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            length = Math.max(recursion(i, nums, nums[i]), length);
        }
       return length;
    }

    private int recursion (int index, int[] nums, int num) {
        if (index >= nums.length) return 0;
        int choose = 1;
        int skip = 1;
        int len = 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (num < nums[i]) {
                choose = 1 + recursion (i, nums, nums[i]);
            }
            skip = recursion (i, nums, num) ;
            len = Math.max(Math.max(choose, skip) ,len);
        }
        return len;
    }
}
