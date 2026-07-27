class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        return recursion(word1, word2, n, m);
    }

    private int recursion(String s1, String s2, int n, int m) {
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n ;
        }

        if (s1.charAt(n-1) == s2.charAt(m-1)) {
            return 0 + recursion(s1,s2,n-1,m-1);
        }
        else {
            int insert = 1 + recursion(s1,s2,n, m-1);
            int replace = 1 + recursion(s1, s2, n-1, m-1);
            int delete = 1 + recursion(s1, s2, n-1, m);

            int min = Math.min(insert, replace);
            return Math.min(min, delete);
        }
    }
}
