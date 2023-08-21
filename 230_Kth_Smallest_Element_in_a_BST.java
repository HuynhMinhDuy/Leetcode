/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
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
    private int n ;
    private int ans;    
    public int kthSmallest(TreeNode root, int k) {
        n = k;
        solve(root);
        return ans;
    }
    public void solve(TreeNode root) {      
      if(n > 0 &&  root.left != null) {
        solve(root.left);
      }            
      --n;
      if(n == 0) ans = root.val;
      if(n > 0 && root.right != null) {
        solve(root.right);
      }
    
    }
}
