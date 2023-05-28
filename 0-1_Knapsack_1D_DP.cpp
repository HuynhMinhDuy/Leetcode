
/*
  https://www.interviewbit.com/problems/0-1-knapsack/
  Problem Description

  Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

  Also given an integer C which represents knapsack capacity.

  Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

  NOTE:

  You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
*/
int Solution::solve(vector<int>& values, vector<int>& weights, int capacity) {
    int maxProfit  = 0;
    vector<int> dp(capacity + 1, -1);
    dp[0] = 0;
    for(int i = 0; i < weights.size(); ++i) {
        int weight =  weights[i];
        for(int cap = capacity; cap - weight >= 0; --cap) {
            if(dp[cap - weight] != -1) {
                dp[cap] = max(dp[cap], dp[cap - weight] + values[i]);
                maxProfit = max(maxProfit, dp[cap]);
            }
        }
    }    
    return maxProfit;
}
