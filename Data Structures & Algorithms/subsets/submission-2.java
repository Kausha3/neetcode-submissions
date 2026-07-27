class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int index, List<List<Integer>> result, List<Integer> path) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        path.add(nums[index]);
        backtrack(nums, index + 1, result, path);

        path.remove(path.size() - 1);
        backtrack(nums, index + 1, result, path);
    }
}
