/*
  https://leetcode.com/problems/course-schedule/description/
  
  There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

  For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
  Return true if you can finish all courses. Otherwise, return false.

*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        int finishedCourses = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int course = 0; course < numCourses; ++course) {
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            ++indegree[pre[0]];
        }

        for(int course = 0; course < numCourses; ++course) {
            if(indegree[course] == 0){
                ++finishedCourses;
                q.add(course);
            }
        }

        while(!q.isEmpty()) {
            int currentCourse = q.poll();
            List<Integer> childCourses = graph.get(currentCourse);
            for(int childCourse : childCourses) {
                --indegree[childCourse];
                if(indegree[childCourse] == 0) {
                    ++finishedCourses;
                    q.add(childCourse);
                }
            }
        }

        return finishedCourses == numCourses ? true : false;
    }
}
