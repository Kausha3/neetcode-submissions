class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return recursion (s, wordDict, 0, dp);
    }
    private boolean recursion(String s, List<String> wordDict, int index, int[] dp) {
        if (index >= s.length()) {
            return true;
        }
        for (String str: wordDict) {
            int length = str.length();
            if (length + index <= s.length()) {
                if (s.substring(index, length + index).equals(str)) {
                    if (dp[index + length] != -1) {
                        return dp[index + length] == 1 ? true : false;
                    }

                    if (recursion(s, wordDict, index + length, dp) == true) {
                        dp[index+length] = 1;
                        return true;
                    }
                    else {
                        dp[index + length] = 0;
                        continue;
                    }
                }
            }
        }
        return false;
    }
}
