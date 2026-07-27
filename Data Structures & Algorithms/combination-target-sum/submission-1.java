class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recursionFindSum(nums, target, res, 0, new ArrayList<>());
        return res;
        
    }

    private void recursionFindSum(int[] nums, int target, List<List<Integer>> res, int i, List<Integer> subList) {
        if (target == 0) {
            res.add(new ArrayList<>(subList));
            return;
        }
        if (i == nums.length) {
            return;
        }
        if (nums[i] > target) {
            return;
        }

        subList.add(nums[i]);
        recursionFindSum(nums, target - nums[i], res, i, subList);
        subList.remove(subList.size() - 1);
        recursionFindSum(nums, target, res, i + 1, subList);
    }
}
