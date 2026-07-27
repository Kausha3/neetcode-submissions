class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node (int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    Node (int key, int value, Node prev, Node next) {
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {
    private int cap = 0;
    HashMap<Integer, Node> hashmap = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
        hashmap.clear();
    }
    
    public int get(int key) {
        if (!hashmap.containsKey(key)) {
            return -1;
        }
        Node node = hashmap.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (hashmap.containsKey(key)) {
            Node node = hashmap.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        }
        else {
            if (cap == hashmap.size()) {
                Node lru = tail.prev;
                deleteNode(lru);
                hashmap.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insertAfterHead(newNode);
            hashmap.put(key, newNode);
        }
        
    }

    private void deleteNode (Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertAfterHead (Node node) {
        Node currAfterHead = head.next;
        head.next = node;
        node.prev = head;
        node.next = currAfterHead;
        currAfterHead.prev = node;
    }
}
