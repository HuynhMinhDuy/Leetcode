/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
  */

class Solution {
    public int orangesRotting(int[][] grid) {

        int numberOfFresh = 0;
        int minTime = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int row = 0; row < grid.length; ++row) {
            for(int col = 0; col < grid[0].length; ++col) {
                if(grid[row][col] == 2) {
                    q.add(new int[]{row, col});                    
                } else if(grid[row][col] == 1) {
                    ++numberOfFresh;
                }
            }
        }

        if(numberOfFresh == 0) return 0;

        while(!q.isEmpty()) {
            int sz = q.size();
            
            for(int i = 0; i < sz; ++i) {
                int[] currentCell = q.poll();
                int currentRow = currentCell[0];
                int currentCol = currentCell[1];

                for(int[] direction : directions) {
                    int newRow = currentRow + direction[0];
                    int newCol = currentCol + direction[1];
                    if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1) {
                        --numberOfFresh;
                        grid[newRow][newCol] = Integer.MAX_VALUE;
                        q.add(new int[]{newRow, newCol});
                    }
                }
            }

            ++minTime;
        }

        return numberOfFresh == 0 ? minTime - 1 : -1;
    }
}
