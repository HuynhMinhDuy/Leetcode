/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;        
        int[][] ans = new int[rows][cols];
        Queue<int []> q = new LinkedList<>();
        int[][] moves = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};        

        for(int row = 0; row < rows; ++row){
            for(int col = 0; col < cols; ++col) {
                if(mat[row][col] == 1) {
                    ans[row][col] = Integer.MAX_VALUE;
                } else {
                    q.add(new int[]{row , col});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] currentCell = q.poll();            
            for(int[] move : moves) {
                int nextMoveX = currentCell[0] + move[0];
                int nextMoveY = currentCell[1] + move[1];
                if(nextMoveX >= 0 && nextMoveX < rows && nextMoveY >= 0 && nextMoveY < cols) {
                    if(ans[nextMoveX][nextMoveY] > ans[currentCell[0]][currentCell[1]]) {
                        ans[nextMoveX][nextMoveY] = ans[currentCell[0]][currentCell[1]] + 1;
                        q.add(new int[]{nextMoveX, nextMoveY});
                    }
                }
            }
        }

        return ans;
    }
}
