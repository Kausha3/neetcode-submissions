class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maxLength = 0;

        for (int i = 0; i < nums.length ; i++) {
            if(!set.contains(nums[i] - 1)) {
                int flag = 0;
                int num = nums[i];
                int length = 0;
                while(flag == 0) {
                    if(set.contains(num)) {
                        num++;
                        length = length + 1;
                    }
                    else {
                        flag = 1;
                    }
                }
                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }
        return maxLength;
        
    }
}
