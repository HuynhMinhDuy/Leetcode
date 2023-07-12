/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order. 

*/
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int numberNodes = graph.length;
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> newGraph = new ArrayList<>(); 
        boolean[] safeNodes = new boolean[numberNodes];
        int[] degree = new int[numberNodes];
        for(int i = 0; i < numberNodes; ++i){
            newGraph.add(new ArrayList<>());
        }

        for(int i = 0; i < numberNodes; ++i) {
            int[] g = graph[i];
            degree[i] = g.length;
            for(int node : g) {
                newGraph.get(node).add(i);
            }
        }

        Queue<Integer> q  = new LinkedList<>();

        for(int i = 0; i < degree.length; ++i) {
            if(degree[i] == 0) {
                q.add(i);
                safeNodes[i] = true;
            }
        }

        while(!q.isEmpty()) {
            int currentNode = q.poll();
            List<Integer> childs = newGraph.get(currentNode);
            for(int child : childs) {
                --degree[child];
                if(degree[child] == 0) {
                    q.add(child);
                    safeNodes[child] = true;
                }
            }
        }        

        for(int node = 0; node < safeNodes.length; ++node){
            if(safeNodes[node] == true){
                ans.add(node);
            }
        }
        
        return ans;
    }
}
