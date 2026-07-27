/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        //Iterative solution
        // ListNode temp = head;
        // ListNode prev = null;
        // while (temp != null) {
        //     ListNode front = temp.next;
        //     temp.next = prev;
        //     prev = temp;
        //     temp = front;
        // }
        // return prev;

        //Recursive solution
        return reverse(head);

    }
    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode newHead = reverse(node.next);
        ListNode front = node.next;
        front.next = node;
        node.next = null;
        return newHead;
    }
}
