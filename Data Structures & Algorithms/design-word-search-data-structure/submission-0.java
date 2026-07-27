class Node {
    HashMap<Character, Node> childrens = new HashMap<>();
    boolean isEnd = false;

    boolean containsKey(char ch) {
        return (childrens.get(ch) != null);
    }
    void put(char ch, Node node) {
        childrens.put(ch, node);
    }

    Node get(char ch) {
        return childrens.get(ch);
    }
    void setEnd() {
        isEnd = true;
    }
    boolean getEnd() {
        return isEnd;
    }

    Collection<Node> getChildren() {
        return childrens.values();
    }
}

class WordDictionary {
    private Node root = new Node();

    public WordDictionary() {
    }

    public void addWord(String word) {
        Node node = root;
        for (char ch: word.toCharArray()) {
            if(!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return dfsSearch(word, 0, root);
    }

    private boolean dfsSearch(String word, int index, Node node) {
        if (index == word.length()) {
            return node.getEnd();
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (Node child : node.getChildren()) {
                if (dfsSearch(word, index + 1, child)) {
                    return true;  
                }
            }
            return false;      
        }
        else {
            if(!node.containsKey(ch)) return false;
            return dfsSearch(word, index + 1, node.get(ch));
        }
    }
}
