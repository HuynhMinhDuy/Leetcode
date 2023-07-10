/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            return 1;
        }
        int minLeft = Integer.MAX_VALUE;
        int minRight = Integer.MAX_VALUE;
        if(root.left != null)  {
            minLeft =  1 + minDepth(root.left);
        }
        if(root.right != null) {
            minRight = 1 + minDepth(root.right);
        }

        return Math.min(minLeft, minRight);
    }

    
}
