class Solution {
    public String foreignDictionary(String[] words) {
		Map<Character, List<Character>> adjList = new HashMap<>();

		for (String str: words) {
			for (char ch: str.toCharArray()) {
				adjList.putIfAbsent(ch, new ArrayList<>());
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String s1 = words[i];
			String s2 = words[i+1];
			int minLength = Math.min(s1.length(), s2.length());

			if (s1.length() > s2.length() && s1.startsWith(s2)) return "";

			for (int j = 0; j < minLength; j++) {
				if (s1.charAt(j) != s2.charAt(j)) {
					adjList.get(s1.charAt(j)).add(s2.charAt(j));
					break;
				}
			}
		}

		int[] states = new int[26];
		StringBuilder sb = new StringBuilder();
		
		for (char c: adjList.keySet()) {
			if (states[c - 'a'] == 0) {
				if(!dfs(c, adjList, states, sb))return "";
			}
		}
        sb.reverse();
		return sb.toString();
	}

	private boolean dfs(char ch, Map<Character, List<Character>> adjList, int[] states, StringBuilder sb ) {
		
		if (states[ch - 'a'] == 1) return false;
		if (states[ch - 'a'] == 2) return true;

		states[ch - 'a'] = 1;

		List<Character> neighbours = adjList.get(ch);

		for (char neigh: neighbours) {
			if(!dfs(neigh, adjList, states, sb)) return false;
		}

		states[ch - 'a'] = 2;
		sb.append(ch);
		return true;
	}
}
