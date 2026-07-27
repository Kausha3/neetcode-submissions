class Pair<T, U> {
   private T first; 
   private U second;
    Pair (T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() { return first; }
    public U getSecond() { return second; }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        HashSet<String> hs = new HashSet<>();

        for (String str: wordList) {
            hs.add(str);
        }
        if (!hs.contains(endWord)) return 0;

        queue.offer(new Pair<>(beginWord, 1));

        while(!queue.isEmpty()) {
            Pair<String,Integer> node = queue.poll();
            String s = node.getFirst();
            int level = node.getSecond();

            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder(s);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    sb.setCharAt(i, ch);
                    String candidate = sb.toString();

                    if (hs.contains(candidate)) {

                        if (candidate.equals(endWord)) {
                            return level + 1;
                        }
                        queue.offer(new Pair(candidate, level + 1));
                        hs.remove(candidate);
                    }
                }
            }
        }
        return 0;
    }
}
