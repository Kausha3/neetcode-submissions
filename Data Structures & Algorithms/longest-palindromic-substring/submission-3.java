class Solution {
    public String longestPalindrome(String s) {
        int[] ans = new int[3];
        //int[0] = max_length
        //int[1] = left
        //int[2] = right

        for (int i = 0; i < s.length(); i++) {
            recursion(i, i, s, ans);
            recursion(i, i+1, s, ans);
        }
        return s.substring(ans[1], ans[2] + 1);
        
    }

    private void recursion(int left, int right, String s, int[] ans) { 
        if (left < 0 || right >= s.length()) return;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (ans[0] < right - left + 1) {
                ans[0] = right - left + 1;
                ans[1] = left;
                ans[2] = right;
            }
            left--;
            right++;
        }
    }
}
