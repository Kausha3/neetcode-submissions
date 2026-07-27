class Solution {
    public boolean hasDuplicate(int[] nums) {
        List<Integer> hashMap = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.contains(nums[i])) {
                return true;
            }
            hashMap.add(nums[i]);
        }
        return false;
    }
}