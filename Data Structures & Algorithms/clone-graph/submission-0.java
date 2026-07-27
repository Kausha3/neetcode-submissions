/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Node rootNode = new Node(node.val);
        Map<Node, Node> hashMap = new HashMap<>();
        hashMap.put(node, rootNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current != null) {
                for (Node adj : current.neighbors) {
                    if (!hashMap.containsKey(adj)) {
                        Node newNode = new Node(adj.val);
                        hashMap.put(adj, newNode);
                        queue.offer(adj);
                    }
                    Node n = hashMap.get(current);
                    n.neighbors.add(hashMap.get(adj));
                    }
                }
        }
        return rootNode;
    }
}