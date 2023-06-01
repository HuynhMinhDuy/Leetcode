
/*
https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.
*/


class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
       
        int shortestPath = 0;       
        
        if(grid[0][0] == 0) {
            int row = grid.length;
            int col = grid[0].length;
            boolean[][] visited = new boolean[row][col];
            int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1 , 1}, {1, -1}, {1, 1}};
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{0,0});
            visited[0][0] = true;

            while(!q.isEmpty()) {
                int sz = q.size();

                for(int i = 0; i< sz; ++i) {
                    int[] currentCell = q.poll();     

                    if(currentCell[0] == row - 1 && currentCell[1] == col - 1) {
                            return shortestPath + 1;
                    }

                    for(int[] move : moves) {
                        int nextMoveX = currentCell[0] + move[0];
                        int nextMoveY = currentCell[1] + move[1]                        

                        if(nextMoveX >= 0 && nextMoveX < row && nextMoveY >= 0 
                            && nextMoveY < col && grid[nextMoveX][nextMoveY] == 0 
                            && visited[nextMoveX][nextMoveY] ==false){
                                visited[nextMoveX][nextMoveY] = true;
                                q.add(new int[] {nextMoveX, nextMoveY});
                            }
                    }                
                }
                ++shortestPath;
            }
        }       

        return -1 ;
    }
}
