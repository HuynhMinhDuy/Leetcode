
/*
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];

        for(int row = 0; row < rows; ++row) {
            for(int col = 0; col < cols; ++col) {
                if(matrix[row][col] == '1') {
                    dp[row + 1][col + 1] = Math.min(dp[row][col + 1], Math.min(dp[row + 1][col], dp[row][col])) + 1;
                    ans = Math.max(ans, dp[row + 1][col + 1]);
                }
            }
        }        

        return ans * ans;
    }
}
