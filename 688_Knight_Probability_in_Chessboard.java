
/*
On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.
Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly k moves or has moved off the chessboard.

Return the probability that the knight remains on the board after it has stopped moving.
*/
class Solution {
    public double knightProbability(int n, int k, int r, int c) {

        int[][] directions = {{-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}};
        double[][][] dp = new double[k + 1][n][n];
        dp[0][r][c] = 1;
        double totalProb = 0;

        for(int move = 1; move <= k; ++move) {
            for(int row = 0; row < n; ++row) {
                for(int col = 0; col < n; ++col) {
                    double currenProb = 0;
                    for(int[] direction : directions) {
                        int reachingX = row + direction[0];
                        int reachingY = col + direction[1];
                        if(reachingX >= 0 && reachingX < n && reachingY >= 0 && reachingY < n) {
                            currenProb += dp[move - 1][reachingX][reachingY];
                        }
                    }
                    dp[move][row][col] = currenProb / 8;
                }
            }
        }

        for(int row = 0 ; row < n; ++row) {
            for(int col = 0; col < n; ++col) {
                totalProb += dp[k][row][col];
            }
        }

        return totalProb;
    }
}
