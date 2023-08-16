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
/*
You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.
*/
class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode root = new ListNode(0);
        ListNode ans = root;
        root.next = head;

        while(root != null) {            
            root.val = (root.val * 2) % 10;
            if(root.next != null && root.next.val > 4) {
                root.val += 1;
            }
            root = root.next;
        }

        return ans.val != 0 ? ans : head;
    }
}
