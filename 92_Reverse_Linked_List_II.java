
/*
Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftNode = null;
        ListNode rightNode = null;
        ListNode root = head;
        ListNode startNode = null;
        int nodeNumber = 1;
        while(nodeNumber <= right) {
            if(nodeNumber == left - 1) {
                startNode = root;
            }
            if(nodeNumber == left) {
                leftNode = root;
            }
            if(nodeNumber == right) {
                rightNode = root;
            }
            root = root.next;
            ++nodeNumber;
        }
        
        ListNode lastNode = rightNode.next;
        // Reverse list 
        root = leftNode;
        ListNode prevNode = null;
        while(root != lastNode){           
            ListNode nextNode = root.next;
            root.next = prevNode;
            prevNode = root;
            root = nextNode;
        }
        leftNode.next = lastNode;

        if(startNode == null) {
            head = prevNode;
        } else {
            startNode.next = prevNode;
        }        

        return head;
    }
}
