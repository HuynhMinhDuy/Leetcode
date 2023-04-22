/*
  https://leetcode.com/problems/add-two-numbers/description/
  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode ans = head;
        int c = 0 ;

        while(l1 != null || l2 != null || c != 0) {
            int val1 = 0;
            int val2 = 0;
            if(l1 != null)  {
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2  + c;
            c = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            head.next = newNode;
            head = newNode;
        }

        return ans.next;
    }
}
