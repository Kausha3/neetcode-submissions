class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String str: strs) {
            int[] countFreq = new int[26];
            for(char ch: str.toCharArray()) {
                countFreq[ch - 'a']++;
            }

            String key = Arrays.toString(countFreq);

            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new ArrayList<>());
            }
            
            hashMap.get(key).add(str);
            
        }
        return new ArrayList<>(hashMap.values());
        
    }
}
