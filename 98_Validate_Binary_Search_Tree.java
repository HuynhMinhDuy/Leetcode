/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left 
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean isValid = true;
    private TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return isValid;
    }
    public void inOrder(TreeNode root) {
        if(isValid == true && root.left != null) {
            inOrder(root.left);
        }

        if(prev != null && prev.val >= root.val) {            
            isValid = false;                      
        }
        prev = root;

        if(isValid == true && root.right != null) {
            inOrder(root.right);
        }
    }
}
