class Solution {
    public String longestPalindrome(String s) {
        int[] max = new int[3];
        for (int i = 0; i < s.length(); i++) {
            recursion(s, i, i, max);
            recursion(s, i, i + 1, max);
        }
        return s.substring(max[1], max[2] + 1);
    }

    private void recursion(String s, int left, int right, int[] max) {

        while (left >= 0 && right < s.length()) {
             if (s.charAt(left) != s.charAt(right)) {
                return;
             }
             else {
                if (max[0] <= right - left + 1) {
                    max[0] = right - left + 1;
                    max[1] = left;
                    max[2] = right;
                }
             }
            left--;
            right++;
        }
        return;
    }
}
