class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd count

            int left = i; int right = i;

            while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res = res + 1;
                left--;
                right++;
            }

            //even length

            left = i;
            right = i + 1;

            while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res = res + 1;
                left--;
                right++;
            }
        }
        return res;
    }
}
