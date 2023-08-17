
/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dp = new int[rows][cols];

        for(int row = 0; row < rows; ++row) {
            for(int col = 0; col < cols; ++col) {
                if(mat[row][col] == 1) {
                    dp[row][col] = Integer.MAX_VALUE - 1;
                }
            }
        }

        // from top left down -- > bottom right 
        for(int row = 0; row < rows; ++row) {
            for(int col = 0; col < cols; ++col) {
                if(row == 0 && col > 0) {
                    dp[row][col] = Math.min(dp[row][col], 1 + dp[row][col - 1]);
                }  else if (col == 0 && row > 0) {
                    dp[row][col] = Math.min(dp[row][col], 1 + dp[row - 1][col]);
                } else if(row > 0 && col > 0) {
                    dp[row][col] = Math.min(dp[row][col], 1 + Math.min (dp[row - 1][col], dp[row][col - 1]));
                }
            }
        }

        //from botom right -> top
        for(int row = rows - 1; row >= 0; --row) {
            for(int col = cols - 1; col >= 0; --col) {
                if(row == rows - 1 && col < cols - 1) {
                    dp[row][col] = Math.min(dp[row][col], 1 + dp[row][col + 1]);
                } else if (col == cols - 1 && row < rows - 1){
                    dp[row][col] = Math.min(dp[row][col], 1 + dp[row + 1][col]);
                } else if(row < rows - 1 && col < cols -1) {
                    dp[row][col] = Math.min(dp[row][col], 1 + Math.min(dp[row + 1][col], dp[row][col + 1]));
                }
            }
        }

        return dp;
    }
}
