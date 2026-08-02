class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] d: dp) {
            Arrays.fill(d, -1);
        }
        return recurse(word1.length() - 1, word2.length() - 1, word1, word2, dp);
    }

    private int recurse(int lenS, int lenP, String s, String p, int[][] dp) {
        if (lenS < 0) return lenP + 1;
        if (lenP < 0) return lenS + 1;

        if (dp[lenS][lenP] != -1) return dp[lenS][lenP];

        int op = Integer.MAX_VALUE;
        int insert = Integer.MAX_VALUE; int delete = Integer.MAX_VALUE; 
        int replace = Integer.MAX_VALUE;
        if (s.charAt(lenS) == p.charAt(lenP)) {
            op = 0 + recurse(lenS - 1, lenP - 1, s, p, dp);
        }
        else {
            //insert 
            insert = 1 + recurse(lenS, lenP - 1, s, p, dp);
            delete = 1 + recurse(lenS - 1, lenP, s, p, dp);
            replace = 1 + recurse(lenS - 1, lenP - 1, s, p, dp);
        }
        return dp[lenS][lenP] = Math.min(Math.min(insert, delete), Math.min(replace, op));
    }
}
