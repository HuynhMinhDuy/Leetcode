
/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if(n == 1) return 1;

        int[] dp = new int[n];
        int[] prevDP = new int[n];
        int ans = 1;
        Arrays.fill(prevDP, 1);
        dp[0] = 1;
        for(int row = 1; row < m; ++row) {
            for(int col = 1; col < n; ++col) {
                dp[col] = dp[col - 1] + prevDP[col];
            }       
            ans = dp[n - 1];     
            int[] tmp = prevDP;
            prevDP = dp;
            dp = tmp;
        }
        return ans;
    }
}
