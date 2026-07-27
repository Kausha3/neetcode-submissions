class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            length = Math.max(recursion(i, nums), length);
        }
       return length;
    }

    private int recursion (int index, int[] nums) {
        if (index >= nums.length) return 0;
        int choose = 1;
        int len = 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[index] < nums[i]) {
                choose = 1 + recursion (i, nums);
            }
            len = Math.max(choose ,len);
        }
        return len;
    }
}
