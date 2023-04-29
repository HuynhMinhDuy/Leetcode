/*
  https://leetcode.com/problems/minimum-path-sum/description/
  
  Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

  Note: You can only move either down or right at any point in time.
*/

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int inf = 200000;
        int row = grid.size();
        int col = grid[0].size();
        vector<int> dp(col, inf);
        
        dp[0] = 0;
        for(int i = 0; i < row; ++i) {
            dp[0] += grid[i][0];
            for(int j = 1; j < col; ++j) {
                dp[j] = min(dp[j] + grid[i][j], dp[j - 1] + grid[i][j]);
            }              
        }

        return dp[col - 1];
    }
};
