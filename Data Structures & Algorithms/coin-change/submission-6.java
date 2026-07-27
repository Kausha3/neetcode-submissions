class Solution {
    public int coinChange(int[] capacities, int requiredCapacity) {
        List<Integer> list = new ArrayList<>();
        if (requiredCapacity == 0) return 0;
        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        recurse(0, capacities, requiredCapacity, list, min);
        return min[0] == Integer.MAX_VALUE? -1: min[0];
    }
    private void recurse(int index, int[] capacities, int target, List<Integer> list, int[] min) {
	    if (index >= capacities.length) return;
	    if (target == 0) { min[0] = Math.min(min[0], list.size()); return;}


        if (capacities[index] <= target) {
            list.add(capacities[index]);
            recurse(index, capacities, target-capacities[index], list, min);
            list.remove(list.size() - 1);
        }
	    recurse(index + 1, capacities, target, list, min);
    }
}
