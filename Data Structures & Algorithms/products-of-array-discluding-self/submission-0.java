class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] resArray = new int[nums.length];
        int preFix = 1;
        resArray[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            resArray[i] = preFix;
            preFix *= nums[i];
        }

        int postFix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            resArray[i] *= postFix;
            postFix *= nums[i];
        }
        return resArray;
    }
}  
