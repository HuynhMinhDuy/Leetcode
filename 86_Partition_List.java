/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

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
/
class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode beginSmaller = null;
        ListNode beginGreater = null;
        ListNode endSmaller = null;
        ListNode endGreater = null;

        while(head != null) {
            ListNode nextNode = head.next;
            if(head.val < x) {
                if(beginSmaller == null) {
                    beginSmaller = head;
                }

                if(endSmaller == null) {
                    endSmaller = head;
                } else {
                    endSmaller.next = head;
                    endSmaller = head;
                }
            } else {

                if(beginGreater == null) {
                    beginGreater = head;
                }

                if(endGreater == null) {
                    endGreater = head;
                } else {
                    endGreater.next = head;
                    endGreater = head;
                }
            }
            head.next = null;
            head = nextNode;
        }

        if(endSmaller != null) endSmaller.next = beginGreater;

        return beginSmaller != null ? beginSmaller : beginGreater;
    }
}
