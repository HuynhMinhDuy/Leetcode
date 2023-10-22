/*

You are given a 0-indexed 2D matrix grid of size n x n, where (r, c) represents:

A cell containing a thief if grid[r][c] = 1
An empty cell if grid[r][c] = 0
You are initially positioned at cell (0, 0). In one move, you can move to any adjacent cell in the grid, including cells containing thieves.

The safeness factor of a path on the grid is defined as the minimum manhattan distance from any cell in the path to any thief in the grid.

Return the maximum safeness factor of all paths leading to cell (n - 1, n - 1).

An adjacent cell of cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) and (r - 1, c) if it exists.

The Manhattan distance between two cells (a, b) and (x, y) is equal to |a - x| + |b - y|, where |val| denotes the absolute value of val.
*/
class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int ans = 0;

        buildGraph(grid);

        int left = 0; 
        int right = grid.size();        

        while(left <= right) {

            int mid = left + (right - left) / 2;

            if(mid<= grid.get(0).get(0) && BFS(grid, mid)) {                
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }      

        return ans - 1;
    }

    public boolean BFS(List<List<Integer>> grid, int mid) {

        Queue<int[]> q = new LinkedList<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int rows = grid.size();
        int cols = grid.get(0).size();

        boolean[][] visited = new boolean[rows][cols];

        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] currentCell = q.poll();
            int currentRow = currentCell[0];
            int currentCol = currentCell[1];
            if(currentRow == rows - 1 && currentCol == cols - 1) {
                return true;
            }

            for(int[] direction : directions) {
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if(newRow >= 0 && newRow < grid.size() && newCol >= 0 && newCol < grid.get(0).size()) {
                    if(grid.get(newRow).get(newCol) >= mid && visited[newRow][newCol] == false) {
                        q.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }

        return false;
    }


    public void buildGraph(List<List<Integer>> grid) {
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        for(int row = 0; row < grid.size(); ++row) {
            List<Integer> cols = grid.get(row);
            for(int col = 0; col < cols.size(); ++col) {
                if(cols.get(col) == 1) {
                    q.add(new int[]{row, col});
                }
            }
        }

        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i = 0; i < sz; ++i) {
                int[] currentCell = q.poll();
                int currentRow = currentCell[0];
                int currentCol = currentCell[1];
                int currentVal = grid.get(currentRow).get(currentCol);

                for(int[] direction : directions){
                    int newRow = currentRow + direction[0];
                    int newCol = currentCol + direction[1];
                    
                    if(newRow >= 0 && newRow < grid.size() && newCol >= 0 && newCol < grid.get(0).size()) {
                        List<Integer> cols = grid.get(newRow);
                        if(cols.get(newCol) == 0 ||  currentVal + 1 < cols.get(newCol)) {
                            cols.set(newCol, currentVal + 1 );
                            q.add(new int[] {newRow, newCol});
                        }
                    }
                }
            }
        }
    }
}
  
