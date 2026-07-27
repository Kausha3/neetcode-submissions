class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return recursion(text1, text2, text1.length(), text2.length(), dp);
    }

    private int recursion(String s1, String s2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) return 0;

        if (dp[n][m] != -1) return dp[n][m];
        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return dp[n][m] = 1 + recursion(s1, s2, n-1,m-1,dp);
        }
        else {
            return dp[n][m] = Math.max(recursion(s1,s2,n,m-1,dp), recursion(s1,s2,n-1,m,dp));
        }
    }
}
