class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        int s3Length = s3.length();

        if (s1Length + s2Length != s3Length) return false;
        int[][] dp = new int[s1Length + 1][s2Length + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return recursion(s1, s2, s3, s1Length, s2Length, s3Length, dp);
    }
    private boolean recursion(String s1, String s2, String s3, int s1Len, int s2Len, int s3Len, int[][] dp) {
        if (s3Len == 0) return s1Len == 0 && s2Len == 0 ;
        if (dp[s1Len][s2Len] == 0) return false;
        if (dp[s1Len][s2Len] == 1) return true;

        boolean possible = ((s1Len > 0 && s1.charAt(s1Len - 1) == s3.charAt(s3Len - 1)) &&
            recursion(s1, s2, s3, s1Len - 1, s2Len, s3Len - 1, dp)) ||
            ((s2Len > 0 && s2.charAt(s2Len - 1) == s3.charAt(s3Len - 1)) &&
            recursion(s1, s2, s3, s1Len, s2Len - 1, s3Len - 1, dp));
        dp[s1Len][s2Len] = possible == true? 1 : 0;
        return possible;
    }
}
