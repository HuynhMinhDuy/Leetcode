/*
https://leetcode.com/problems/binary-tree-right-side-view/description

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) {
            q.add(root);
            while(!q.isEmpty()) {
                int sz = q.size();
                for(int i = 0; i < sz; ++i) {
                    TreeNode currentNode = q.poll();
                    if(currentNode.left != null) q.add(currentNode.left);
                    if(currentNode.right != null) q.add(currentNode.right);
                    if(i == sz - 1) {
                        ans.add(currentNode.val);
                    }

                }
            }
        }
        return ans;
    }
}
