class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        return recursion(s, wordDict, 0, dp); 
    }

    private boolean recursion(String s, List<String> wordDict, int index, int[] dp) {
        if (index >= s.length()) {
            return true;
        }
        if (dp[index] != 0) {
            return dp[index] == 1? true : false;
        }
        boolean found = false;
        for (String str: wordDict) {
            int len = str.length();
            if (!(index + len <= s.length())) continue;
            if (s.substring(index, index + len ).equals(str)) {
                found = recursion(s, wordDict, index + len, dp);
            }
            if (found) {
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = -1;
        return found;
    }
}

