class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return recursion(s, wordDict, 0, dp);
    }

    private boolean recursion(String s, List<String> wordDict, int index, int[] dp) {
        if (index >= s.length()) {
            return true;
        }

        if (dp[index] != -1) {
            if (dp[index] == 0) return false;
            else return true;
        } 
        boolean found = false;
        for (String str: wordDict) {
            if (index + str.length() <= s.length()) {
                if (s.substring(index, index + str.length()).equals(str)) {
                    found = recursion(s, wordDict, index + str.length(), dp);
                }
            }
            if (found == true) {
                return true;
            }
        }
        if (found == true) dp[index] = 1;
        else dp[index] = 0;
        return found;
    }
}
