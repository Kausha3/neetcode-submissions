class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i-1] == nums[i]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int k = nums[l] + nums[r] + nums[i];
                if (k == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
                else if (k < 0) l++;
                else r--;
            }
        }
        return result;
    }
}
