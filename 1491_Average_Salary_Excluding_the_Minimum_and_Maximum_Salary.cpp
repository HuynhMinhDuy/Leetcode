/*
  https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/description/
  
  You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

  Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.
*/
class Solution {
public:
    double average(vector<int>& salary) {
        int n = salary.size();
        double sum = 0;
        int minSalary = INT_MAX;
        int maxSalary = INT_MIN;
        for(int val : salary) {
            minSalary = min(minSalary, val);
            maxSalary = max(maxSalary, val);
            sum += val;
        }
        return (sum - minSalary - maxSalary) / (n -2);
    }
};
