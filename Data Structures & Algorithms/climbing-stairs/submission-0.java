class Solution {
    public int climbStairs(int n) {
        int result =  recursion(n);
        return result;
    }

    private int recursion(int index) {
        if (index == 0 || index == 1) {
            return 1;
        }
        return recursion(index - 1) + recursion(index - 2);
    }
}
