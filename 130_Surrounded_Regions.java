/*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
*/

class Solution {

    private char extraChar = 'Z';

    public void solve(char[][] board) {

        for(int col = 0; col < board[0].length; ++col) {
            if(board[0][col] == 'O') {
                BFS(board, 0, col);
            }
            if(board[board.length - 1][col] == 'O') {
                BFS(board, board.length - 1, col);
            }
        }

        for(int row = 0; row < board.length; ++row) {
            if(board[row][0] == 'O') {
                BFS(board, row, 0);
            }
            if(board[row][board[0].length - 1] == 'O') {
                BFS(board, row, board[0].length - 1);
            }
        }


        for(int row = 0; row < board.length; ++row){
            for(int col = 0; col < board[0].length; ++col) {
                  if(board[row][col] == extraChar)   {
                      board[row][col] = 'O';
                  } else if(board[row][col] == 'O') {
                      board[row][col] = 'X';
                  }
            }
        }

       
    }

    public void BFS(char[][] board, int row, int col) {

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        board[row][col] = extraChar;
        q.add(new int[]{row, col});

        while(!q.isEmpty()) {
            int[] currentCell = q.poll();
            int currentRow = currentCell[0];
            int currentCol = currentCell[1];

            for(int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length && board[newRow][newCol] == 'O') {
                    board[newRow][newCol] = extraChar;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }

    }
}
