class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String str: wordDict) {
                int len = str.length();
                if (i + len <= s.length()) {
                    if (s.substring(i, i + len).equals(str)) {
                        dp[i] = dp[i] || dp[i+len];
                    }
                }
            }
        }
        return dp[0];
    }

    // private boolean recursion(String s, List<String> wordDict, int index, int[] dp) {
    //     if (index >= s.length()) {
    //         return true;
    //     }
    //     if (dp[index] != 0) {
    //         return dp[index] == 1? true : false;
    //     }
    //     boolean found = false;
    //     for (String str: wordDict) {
    //         int len = str.length();
    //         if (!(index + len <= s.length())) continue;
    //         if (s.substring(index, index + len ).equals(str)) {
    //             found = recursion(s, wordDict, index + len, dp);
    //         }
    //         if (found) {
    //             dp[index] = 1;
    //             return true;
    //         }
    //     }
    //     dp[index] = -1;
    //     return found;
    // }
}

