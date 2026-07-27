class Node {
    private Node[] childrens = new Node[26];
    private String word = null;

    boolean containsKey(char ch) {
        return (childrens[ch - 'a'] != null);
    }
    void put (char ch, Node node) {
        childrens[ch - 'a'] = node;
    }

    Node get(char ch) {
        return childrens[ch - 'a'];
    }
    void setWord(String str) {
        word = str;
    }
    String getWord() {
        return word;
    }

}

class Solution {
    Node root = new Node();
    private void insertIntoTrie(String[] words) {
        for (String str: words) {
            Node node = root;
            for (char ch: str.toCharArray()) {
                if(!node.containsKey(ch)) {
                    node.put(ch, new Node());
                }
                node = node.get(ch);
            }
            node.setWord(str);
        }
    }

        
    public List<String> findWords(char[][] board, String[] words) {
        insertIntoTrie(words);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                 dfsToFindWords(board, words, i, j, result, root);
            }
        }
        return result;
    }

    void dfsToFindWords(char[][] board, String[] words, int currRow, int currCol, List<String> result, Node node) {
        if(currRow < 0 || currCol < 0 || currRow >= board.length || currCol >= board[0].length) {
            return;
        }

        char ch = board[currRow][currCol];
        if (ch == '#' || !node.containsKey(ch)) return;

        node = node.get(ch);

        if(node.getWord() != null) {
            result.add(node.getWord());
            node.setWord(null);
        }

        board[currRow][currCol] = '#';


        dfsToFindWords(board, words, currRow + 1, currCol, result, node);
        dfsToFindWords(board, words, currRow - 1, currCol, result, node);
        dfsToFindWords(board, words, currRow, currCol + 1, result, node);
        dfsToFindWords(board, words, currRow, currCol - 1, result, node);

        board[currRow][currCol] = ch;

    }
}
