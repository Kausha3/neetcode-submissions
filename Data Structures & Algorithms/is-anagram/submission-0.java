class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> hashmapS = new HashMap<>();
        HashMap<Character, Integer> hashmapT = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (hashmapS.get(s.charAt(i)) == null) {
                hashmapS.put(s.charAt(i), 1);
            }
            else {
                int freq = hashmapS.get(s.charAt(i));
                hashmapS.put(s.charAt(i), freq + 1);
            }

            if (hashmapT.get(t.charAt(i)) == null) {
                hashmapT.put(t.charAt(i), 1);
            }
            else {
                int freq = hashmapT.get(t.charAt(i));
                hashmapT.put(t.charAt(i), freq + 1);
            }
           
        }
        return hashmapS.equals(hashmapT);    
    }
}
