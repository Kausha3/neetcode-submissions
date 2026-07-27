class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxFreq = 0;
        int maxLength = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        while (r < s.length()) {
            if (hashMap.get(s.charAt(r)) == null ) {
                    hashMap.put(s.charAt(r), 1);
            }
            else {
                int currFreq = hashMap.get(s.charAt(r));
                hashMap.put(s.charAt(r), currFreq + 1);
            }
            maxFreq = Math.max (maxFreq, hashMap.get(s.charAt(r)));
            if ((r - l + 1) - maxFreq > k) {
                int currFreq = hashMap.get(s.charAt(l));
                hashMap.put(s.charAt(l), currFreq - 1);
                l++;
            }
            else if ((r - l + 1) - maxFreq <= k) {
                maxLength = Math.max (maxLength, (r - l + 1));
            }
            r++;
        }
        return maxLength;
        
    }
}
