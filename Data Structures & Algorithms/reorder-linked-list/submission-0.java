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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        ListNode prev = null;
        while (secondHalf != null) {
            ListNode temp = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = temp;
        }
        slow.next = null;
        ListNode firstNode = head;
        ListNode secondNode = prev;
        ListNode dNode = new ListNode(-1);
        int i = 1;
        while (firstNode != null && secondNode != null) {
            if (i % 2 != 0) {
                dNode.next = firstNode;
                firstNode = firstNode.next;
                dNode = dNode.next;
            }
            else {
                dNode.next = secondNode;
                secondNode = secondNode.next;
                dNode = dNode.next;
            }
            i++;
        }
        if (firstNode != null) {
            while(firstNode != null) {
                dNode.next = firstNode;
                firstNode = firstNode.next;
                dNode = dNode.next;
            }
        }
        if (secondNode != null) {
            while(secondNode != null) {
                dNode.next = secondNode;
                secondNode = secondNode.next;
                dNode = dNode.next;
            }
        }
    }
}
