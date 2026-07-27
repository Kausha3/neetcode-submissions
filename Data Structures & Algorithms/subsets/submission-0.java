class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helperFindSubset(nums, res, 0, new ArrayList<>());

        return res;
    }

    private void helperFindSubset(int[] nums, List<List<Integer>> res, int i, List<Integer> subList) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subList));
            return;
        }

        subList.add(nums[i]);
        helperFindSubset(nums, res, i + 1,subList);

        subList.remove(subList.size() - 1);

        helperFindSubset(nums, res, i + 1, subList);
    }
}
