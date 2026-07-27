class Solution {
    public String minWindow(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();

        if (lengthS < lengthT) return "";
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < lengthT; i++) {
            char ch = t.charAt(i);
            if (hashMap.get(ch) == null) {
                hashMap.put(ch, 1);
            }
            else {
                int currFreq = hashMap.get(ch);
                hashMap.put(ch, 1 + currFreq);
            }
            
        }
        System.out.println(hashMap);
        int l = 0;
        int r = 0;
        int count = 0;
        int sIndex = -1;
        int minLength = Integer.MAX_VALUE;

        while (r < lengthS) {
            char c = s.charAt(r);
            if (hashMap.get(c) == null ) {
                hashMap.put(c, -1);
            }
            else {
                int freq = hashMap.get(c);
                freq -= 1;
                hashMap.put(c, freq);
                if (freq >= 0) {
                    count++;
                }
            }
            System.out.println(hashMap);
            while (count == lengthT) {
                char ch = s.charAt(l);
                if (r - l + 1 < minLength) {
                    minLength = r - l + 1;
                     sIndex = l;
                }
                int freq1 = hashMap.get(ch);
                freq1 += 1;
                if (freq1 > 0) {
                    count--;
                }
                hashMap.put(ch, freq1);
                l++;

            }
            r++;
        }
        System.out.println("Starting Index" + sIndex + "minLength" + minLength);
        return sIndex == -1? "" : s.substring(sIndex, sIndex + minLength);
        
    }
}
