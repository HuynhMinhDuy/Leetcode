/*
  https://leetcode.com/problems/course-schedule/description/
  
  There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

  For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
  Return true if you can finish all courses. Otherwise, return false.

*/

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> degree(numCourses, 0);
        vector<bool> visited(numCourses, false);
        queue<int> q;
        int finishedCourses = 0;
        for(vector<int> prerequisite : prerequisites) {
            ++degree[prerequisite[0]];
        }

        for (int course = 0; course < degree.size(); ++course) {
            if(degree[course] == 0) {
                q.push(course);
                visited[course] = true;
                ++finishedCourses;
            }
        }

        while(!q.empty()) {
            int currentCourse = q.front();
            q.pop();
            for(vector<int> prerequisite : prerequisites) {
                int course = prerequisite[1];
                int preqCourse = prerequisite[0];
                if(currentCourse == course && visited[preqCourse] == false) {
                    --degree[preqCourse];
                    if(degree[preqCourse] == 0) {
                        q.push(preqCourse);
                        visited[preqCourse] = true;
                        ++finishedCourses;
                    }
                }
            }
        }

        return finishedCourses == numCourses ? true : false;
    }
};
