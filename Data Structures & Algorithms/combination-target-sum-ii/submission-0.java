class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();

        helperCombination2(candidates, target, res, 0, new ArrayList<>());
        return res;

        
    }
    private void helperCombination2(int[] candidates, int target, List<List<Integer>> res, int pointer, List<Integer> subArray) {
        if (target == 0) {
            res.add(new ArrayList<>(subArray));
            return;
        }
        for(int i = pointer; i < candidates.length; i++) {

            if(i > pointer && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] > target) {
                return;
            }
            subArray.add(candidates[i]);
            helperCombination2(candidates, target - candidates[i], res, i + 1, subArray);
            subArray.remove(subArray.size() - 1);
            
        }
    }
}
