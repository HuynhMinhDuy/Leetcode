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
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) {
            q.add(root);
            while(!q.isEmpty()) {
                int sz = q.size();
                for(int i = 0; i < sz ; ++i) {
                    TreeNode node = q.poll();
                    if(node.left == null && node.right == null) return level + 1;
                    if(node.left != null) q.add(node.left);
                    if(node.right != null) q.add(node.right);
                }
                ++level;
            }
        }
        return level;
    }
}
