class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
       HashMap<HashMap<Character, Integer>, List<String>> freqMap = new HashMap<>();

        for (String str: strs) {
             HashMap<Character, Integer> freq = new HashMap<>();
             for (char ch: str.toCharArray()) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
             }
             if (freqMap.containsKey(freq)) {
                freqMap.get(freq).add(str);
             }
             else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                freqMap.put(freq, strings);
             }
        }
        for (List<String> str: freqMap.values()) {
            result.add(str);
        }
        return result;
    }
}
