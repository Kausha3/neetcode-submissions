class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int prefix = 1;
        int sufix = 1;

        for (int i = 0; i < n; i++) {
            if (prefix == 0) prefix = 1;
            if (sufix == 0) sufix = 1;

            prefix = prefix * nums[i];
            sufix = sufix * nums[n - i - 1];

            max = Math.max(max, Math.max(prefix, sufix));
        }

        return max;
        
    }
}
