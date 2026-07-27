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
        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> hashMap = new HashMap<>();

        if (node == null) return null;

        queue.offer(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (!hashMap.containsKey(curr)) {
                Node newNode = new Node (curr.val);
                hashMap.put (curr, newNode);
            }
            for (Node n: curr.neighbors) {
                if (!hashMap.containsKey(n)) {
                    queue.offer(n);
                }
            }
        }
        for (Node oldNode: hashMap.keySet()) {
            Node newNode = hashMap.get(oldNode);

            for (Node n: oldNode.neighbors) {
                newNode.neighbors.add(hashMap.get(n));
            }
        }

        return hashMap.get(node);
    }
}