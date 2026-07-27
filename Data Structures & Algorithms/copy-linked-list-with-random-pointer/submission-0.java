/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Node prevNext = null;

        while (temp != null) {
            Node newNode = new Node(temp.val);
            prevNext = temp.next;
            temp.next = newNode;
            temp.next.next = prevNext;
            temp = temp.next.next;
        }
        temp = head;

        while (temp != null) {
            Node random = temp.random;
            if (random == null) {
                temp.next.random = null;
            }
            else {
                temp.next.random = random.next;
            }
            temp = temp.next.next;
        }
        Node dummy = new Node(-1);
        Node res = dummy;
        temp = head;
        while (temp != null) {
            res.next = temp.next;
            temp.next = temp.next.next; 
            temp = temp.next;
            res = res.next;
            
        }

        return dummy.next;
    }
}
