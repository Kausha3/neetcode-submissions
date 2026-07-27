class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int maxLength = 0;
        int[] arr = new int[256];

        for (int i = 0; i < 256; i++) {
            arr[i] = -1;
        }

        while (r < s.length()) {
            char ch = s.charAt(r);
            if (arr[ch] != -1 && arr[ch] >= l) {
                l = arr[ch] + 1;
            }
            arr[ch] = r;
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
}
