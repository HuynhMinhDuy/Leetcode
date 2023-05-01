/*
  https://leetcode.com/problems/daily-temperatures/description/
  
  Given an array of integers temperatures represents the daily temperatures, 
  return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. 
  If there is no future day for which this is possible, keep answer[i] == 0 instead.

*/

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        stack<int> st;
        vector<int> ans(n, 0);
        for(int i = 0; i < n; ++i) {
            while(!st.empty() && temperatures[i] > temperatures[st.top()]) {
                ans[st.top()] = i - st.top();
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
};
