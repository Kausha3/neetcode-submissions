class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        HashMap<Character, Integer> s1Count = new HashMap<>();
        HashMap<Character, Integer> s2Count = new HashMap<>();

        for (char ch: s1.toCharArray()) {
            if (s1Count.get(ch) == null) {
                s1Count.put(ch, 1);
            }
            else {
                int currFreq = s1Count.get(ch);
                s1Count.put(ch, currFreq + 1);
            }
        }

        int l = 0;
        int r = 0;
        int k = s1.length();

        while (r < s2.length()) {
            char c = s2.charAt(r);
            if (s2Count.get(c) == null) {
                s2Count.put(c, 1);
            }
            else {
                int currFreq = s2Count.get(c);
                s2Count.put(c, currFreq + 1);
            }
            if (r - l + 1 == k) {
                if (s1Count.equals(s2Count))
                    return true;
                char cl = s2.charAt(l);
                int currFreq = s2Count.get(cl);
                currFreq--;
                if (currFreq == 0) {
                    s2Count.remove(cl);
                }
                else s2Count.put(cl, currFreq);
                l++;
            }
            
            r++;
        }
        return false; 
    }
}
