class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String res = "";
        int resLength = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length

            int left = i; int right = i;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (resLength < right - left + 1) {
                    resLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            // even length

             left = i;
             right = i + 1;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (resLength < right - left + 1) {
                    resLength = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return res;
    }

   
}
