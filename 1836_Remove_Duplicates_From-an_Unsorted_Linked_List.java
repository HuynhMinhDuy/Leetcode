/*
Given the head of a linked list, find all the values that appear more than once in the list and delete the nodes that have any of those values.

Return the linked list after the deletions.
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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> m = new HashMap<>();
        ListNode root = head;
        ListNode ans = new ListNode(0); 
        ListNode currentNode = ans;       
        while(root != null){
            m.put(root.val, m.getOrDefault(root.val, 0)  + 1);
            root = root.next;
        }

        root = head;

        while(root != null) {
            ListNode nextNode = root.next;
            if(m.get(root.val) == 1) {
                currentNode.next = root;
                currentNode = root;
            }
            root.next = null;
            root = nextNode;
        }
        return ans.next;
    }
}
