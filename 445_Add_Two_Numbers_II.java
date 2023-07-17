/*
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

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
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();        
        ListNode ans = null;
        while(l1 != null) {
            st1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null) {
            st2.push(l2.val);
            l2 = l2.next;
        }
        int c = 0;
        while(!st1.isEmpty() || !st2.isEmpty() || c != 0) {
            int val1 = 0;
            int val2 = 0;
            int newVal = 0;
            if(!st1.isEmpty()) {
                val1 = st1.pop();
            }

            if(!st2.isEmpty()) {
                val2 = st2.pop();
            }
            newVal = val1 + val2 + c;
            c = newVal / 10;
            ListNode newNode = new ListNode(newVal % 10);
            newNode.next = ans;
            ans = newNode;
        }

        return ans;
    }
    
}
