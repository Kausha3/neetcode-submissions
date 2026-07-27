class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length() ;
        int[][] dp = new int[n + 1][m + 1];
    //     for (int[] row: dp) {
    //         Arrays.fill(row, -1);
    //     }
    //     return recursion(text1, text2, text1.length(), text2.length(), dp);
    // }

    // private int recursion(String s1, String s2, int n, int m, int[][] dp) {
    //     if (n == 0 || m == 0) return 0;

    //     if (dp[n][m] != -1) return dp[n][m];
    //     if (s1.charAt(n-1) == s2.charAt(m-1)) {
    //         return dp[n][m] = 1 + recursion(s1, s2, n-1,m-1,dp);
    //     }
    //     else {
    //         return dp[n][m] = Math.max(recursion(s1,s2,n,m-1,dp), recursion(s1,s2,n-1,m,dp));
    //     }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
}
