class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        } 
        return recursion(word1, word2, n, m, dp);
    }

    private int recursion(String s1, String s2, int n, int m, int[][] dp) {
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n ;
        }
        if (dp[n][m] != -1) return dp[n][m];
        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return dp[n][m] = recursion(s1,s2,n-1,m-1, dp);
        }
        else {
            int insert = 1 + recursion(s1,s2,n, m-1, dp);
            int replace = 1 + recursion(s1, s2, n-1, m-1, dp);
            int delete = 1 + recursion(s1, s2, n-1, m, dp);

            int min = Math.min(insert, replace);
            return dp[n][m] = Math.min(min, delete);
        }
    }
}
