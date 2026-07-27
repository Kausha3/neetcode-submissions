class Node {
    private Node[] childrens = new Node[26];
    private boolean isEnd = false;

    boolean containsKey(char ch) {
        return (childrens[ch - 'a'] != null);
    }

    void put(char ch, Node node) {
        childrens[ch - 'a'] = node;
    }

    void setEnd() {
        isEnd = true;
    }

    boolean getEnd() {
        return isEnd;
    }
    Node get(char ch) {
        return childrens[ch - 'a'];
    }
}

class PrefixTree {

 

    private Node root;
    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = searchNode(word);
        return node != null && node.getEnd();
    }

    public boolean startsWith(String prefix) {
       return searchNode(prefix) != null;
    }

    private Node searchNode(String str) {
        Node node = root;
        for (int i = 0; i < str.length(); i++) {
            if(!node.containsKey(str.charAt(i))) {
                return null;
            }
            node = node.get(str.charAt(i));
        }
        return node;
        
    }
}
