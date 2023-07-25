/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

*/

class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int ans = 0;
        
        for(int row = 0; row < rows; ++row) {
            for(int col = 0; col < cols; ++col){
                if(matrix[row][col] == 1) {
                    dp[row + 1][col + 1] = Math.min(dp[row][col + 1], Math.min (dp[row + 1][col], dp[row][col])) + 1;
                    ans += dp[row + 1][col + 1];
                }
            }
        }

        return ans;
    }
}
