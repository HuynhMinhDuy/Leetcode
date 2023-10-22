/**
  You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
  **/
class Solution {
    public void wallsAndGates(int[][] rooms) {

        Queue<int[]> q = new LinkedList<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for(int row = 0; row < rooms.length; ++row) {
            for(int col = 0; col < rooms[0].length; ++col) {
                if(rooms[row][col] == 0) {
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

                for(int[] direction : directions) {
                    int newRow = currentRow + direction[0];
                    int newCol = currentCol + direction[1];

                    if(newRow >= 0 && newRow < rooms.length && newCol >= 0 && newCol < rooms[0].length && rooms[currentRow][currentCol] + 1 < rooms[newRow][newCol]) {
                            rooms[newRow][newCol] = rooms[currentRow][currentCol] + 1;
                            q.add(new int[]{newRow, newCol});
                    }
                }
            }
        }

    }
    
    
}
 
