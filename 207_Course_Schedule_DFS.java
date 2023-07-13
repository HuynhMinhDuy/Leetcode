
/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
*/
class Solution {

    private boolean isCycle = false;
    private List<List<Integer>> graph = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        boolean[] visited  = new boolean[numCourses];
        boolean[] currentVisted = new boolean[numCourses];

        for(int course = 0; course < numCourses; ++course) {
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        for(int course = 0; course < numCourses && isCycle == false; ++course){
            if(visited[course] == false) {
                DFS(course, visited, currentVisted);
            }
        }

        return isCycle == true ? false : true;
    }

    public void DFS(int course, boolean[] visited, boolean[] currentVisited) {
        if(currentVisited[course] == true) {
            isCycle = true;            
        }

        if(visited[course] == true) return;

        currentVisited[course] = true;
        visited[course] = true;

        List<Integer> childCourses = graph.get(course);
        for(int i = 0; i < childCourses.size() && isCycle == false; ++i) {
            int childCourse = childCourses.get(i);
            DFS(childCourse, visited, currentVisited);                
        }       
        currentVisited[course] = false;       
    }
}
