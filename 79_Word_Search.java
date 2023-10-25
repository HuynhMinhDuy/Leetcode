/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
  vertically neighboring. The same letter cell may not be used more than once. */
class Solution {
    private boolean isExist = false;


    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int row = 0; row < rows; ++row) {
            for(int col = 0; col < cols; ++col) {
                if(isExist == false && board[row][col] == word.charAt(0)) {
                    solve(board, word, row, col, 1);
                }
            }
        }

        return isExist;
    }

    public void solve(char[][] board, String word, int row, int col, int i) {
        if(i == word.length()) {
            isExist = true;
            return;
        }        

        board[row][col] = '#';

        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow >= 0 && newRow < board.length && newCol >= 0 & newCol < board[0].length && board[newRow][newCol] == word.charAt(i) ) {
                solve(board, word, newRow, newCol, i + 1);
            }
        }

        board[row][col] = word.charAt(i - 1);
    }
}
