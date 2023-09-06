/*
Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int listLen = getListLength(head);
        int numberEleEachNode = listLen / k;
        int extraNode = listLen % k;
        int i = 0;

        while(head != null) {
            ListNode root = head;
            int j = 1;
            while(j < numberEleEachNode) {
                head = head.next;
                ++j;
            }

            if(extraNode > 0 && numberEleEachNode != 0) {
                head = head.next;
                --extraNode;
            }

            if(head != null) {
                ListNode nextNode = head.next;
                head.next = null;
                head = nextNode;
            }
            
            ans[i] = root;
            ++i;
        }

        return ans;
    }

    public int getListLength(ListNode head) {
        int len = 0;
        ListNode root = head;
        while(root != null) {
            ++len;
            root = root.next;
        }
        return len;
    }
}
