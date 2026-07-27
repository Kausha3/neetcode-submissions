class Solution {
	public int ladderLength(String begin, String end, List<String> wordList) {
		Set<String> words = new HashSet<>(wordList);

		if (!words.contains(end)) return 0;
		int steps = 1;
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.offer(begin);
		visited.add(begin);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				char[] ch = word.toCharArray();
				for (int l = 0; l < ch.length; l++) {
					char original = ch[l];
				for (char c = 'a'; c <= 'z'; c++) {
					ch[l] = c;
					String newWord = new String(ch);
					if (newWord.equals(end)) return steps + 1;
					if (words.contains(newWord) && !visited.contains(newWord)) {
						visited.add(newWord);
						queue.offer(newWord);
					}
				}
				ch[l] = original;
				}
			}
			steps++;
		}
		return 0;
	}
}

