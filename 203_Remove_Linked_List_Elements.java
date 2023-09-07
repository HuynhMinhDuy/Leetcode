/*
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
*/

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = head;
        ListNode prev = new ListNode(0);
        ListNode ans = prev;
        while(root != null) {
            if(root.val != val) {
                prev.next = root;
                prev = root;      
            } else {
                prev.next = null;
            }            
            root = root.next;
        }

        return ans.next;
    }
}
