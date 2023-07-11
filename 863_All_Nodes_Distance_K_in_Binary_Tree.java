/*
Given the root of a binary tree, the value of a target node target, and an integer k, 
return an array of the values of all nodes that have a distance k from the target node.

You can return the answer in any order.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> graph  = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        DFSToBuildGraph(root, graph);

        // BFS 
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        q.add(target);        
        int level = 0;
        seen.add(target);

        while(!q.isEmpty()) {          

            if(level == k) {
                while(!q.isEmpty()) {
                    TreeNode node = q.poll();
                    ans.add(node.val);
                }
            }
            int sz = q.size();
            for(int i = 0; i < sz; ++i) {
                TreeNode parentNode = q.poll();
                List<TreeNode> childs = graph.get(parentNode);                
                for(TreeNode child : childs) {
                    if(!seen.contains(child)) {
                        seen.add(child);
                        q.add(child);
                    }
                }                
            }
            ++level;           
        }
        return ans;
    }

    public void DFSToBuildGraph(TreeNode root, Map<TreeNode, List<TreeNode>> graph) {
        if(!graph.containsKey(root)) {
            graph.put(root, new ArrayList<>());
        }
        if(root.left != null) {
            if(!graph.containsKey(root.left)) {
                graph.put(root.left, new ArrayList<>());
            }
            graph.get(root).add(root.left);
            graph.get(root.left).add(root);
            DFSToBuildGraph(root.left, graph);
        }

        if(root.right != null) {
            if(!graph.containsKey(root.right)) {
                graph.put(root.right, new ArrayList<>());
            }
            graph.get(root).add(root.right);
            graph.get(root.right).add(root);
            DFSToBuildGraph(root.right, graph);
        }
    }
}
