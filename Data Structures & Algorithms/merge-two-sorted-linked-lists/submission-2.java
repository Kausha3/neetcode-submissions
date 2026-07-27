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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                temp.next = node1;
                temp = temp.next;
                node1 = node1.next;
            }
            else if (node1.val > node2.val) {
                temp.next = node2;
                temp = temp.next;
                node2 = node2.next;
            }
        }

        while (node1 != null ) {
            temp.next = node1;
            temp = temp.next;
            node1 = node1.next;
        }
        while (node2 != null ) {
            temp.next = node2;
            temp = temp.next;
            node2 = node2.next;
        }
        return dummy.next;
    }
}