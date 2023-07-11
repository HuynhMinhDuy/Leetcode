
/*
Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        leafValues(root1, ans1);
        leafValues(root2, ans2);
        
        if(ans1.size() != ans2.size()) return false;
        int idx = 0;
        while (idx < ans1.size()) {
            if(ans1.get(idx) != ans2.get(idx)) return false;
            ++idx;
        }

        return true;
    }

    public void leafValues(TreeNode root, List<Integer> leaf) {        
            if(root.left == null && root.right == null) leaf.add(root.val);
            if(root.left != null) leafValues(root.left, leaf);
            if(root.right != null) leafValues(root.right, leaf);            
    }
    
}
