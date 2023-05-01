/*
https://leetcode.com/problems/daily-temperatures/description/

Given an array of integers temperatures represents the daily temperatures,
return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. 
If there is no future day for which this is possible, keep answer[i] == 0 instead.
*/

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temp) {
        int n =  temp.size();
        vector<int> ans (n, 0);

        for(int i = n - 2; i >= 0; --i) {
            if(temp[i] < temp[i + 1]) {
                ans[i] = 1;
            } else {
                int nextI = (i + 1);
                while(ans[nextI] != 0 && nextI < n && temp[i] >= temp[nextI]) {
                    nextI += ans[nextI];
                }
                if(nextI < n && temp[i] < temp[nextI]) ans[i] = nextI - i;
            }
        }

        return ans;
    }
};
