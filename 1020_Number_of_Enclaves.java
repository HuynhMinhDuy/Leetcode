
/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
*/
class Solution {
    private boolean match = true;
    private int currentLands;
    private int numberLands;

    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int r = 0; r < rows; ++r) {
            for(int c = 0; c < cols; ++c) {
                if(visited[r][c] == false && grid[r][c] == 1) {
                    match = true;
                    currentLands = 0;
                    DFS(grid, r, c, visited);
                    if(match == true){
                        numberLands += currentLands;
                    }
                }
            }
        }
        return numberLands;
    }

    public void DFS(int[][] grid, int r, int c, boolean[][] visited) {

        visited[r][c] = true;
        ++currentLands;

        if(r == 0 || r == grid.length - 1 || c == 0 || c == grid[0].length -1) {
            match = false;
        }

        if(r - 1 >= 0 && grid[r - 1][c] == 1 && visited[r - 1][c] == false){
            DFS(grid, r - 1, c, visited);
        }

        if(r + 1 < grid.length && grid[r + 1][c] == 1 && visited[r + 1][c] == false) {
            DFS(grid, r + 1, c, visited);
        }

        if(c - 1 >= 0 && grid[r][c - 1] == 1 && visited[r][c - 1] == false){
            DFS(grid, r, c - 1, visited);
        }

        if( c + 1 < grid[0].length && grid[r][c + 1] == 1 && visited[r][c + 1] == false) {
            DFS(grid, r, c + 1, visited);
        }
    }
}
