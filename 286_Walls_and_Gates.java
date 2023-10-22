/**
  You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
  **/
class Solution {
    public void wallsAndGates(int[][] rooms) {

        for(int row = 0; row < rooms.length; ++row) {
            for(int col = 0; col < rooms[0].length; ++col) {
                if(rooms[row][col] == 0) {
                    BFS(rooms, row, col);
                }
            }
        }
    }

    public void BFS(int[][] rooms, int row, int col){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        while(!q.isEmpty()) {

            int[] currentCell = q.poll();
            int currentRow = currentCell[0];
            int currentCol = currentCell[1];

            if(currentCol + 1 < rooms[0].length && rooms[currentRow][currentCol] + 1 < rooms[currentRow][currentCol + 1]) {
                rooms[currentRow][currentCol + 1] = rooms[currentRow][currentCol] + 1;
                q.add(new int[]{currentRow, currentCol + 1});
            }

            if(currentRow + 1 < rooms.length && rooms[currentRow][currentCol] + 1 < rooms[currentRow + 1][currentCol]) {
                rooms[currentRow + 1][currentCol] = rooms[currentRow][currentCol] + 1;
                q.add(new int[]{currentRow + 1, currentCol});
            }

            if(currentCol - 1 >= 0 && rooms[currentRow][currentCol] + 1 < rooms[currentRow][currentCol - 1]) {
                rooms[currentRow][currentCol - 1] = rooms[currentRow][currentCol] + 1;
                q.add(new int[]{currentRow, currentCol - 1});
            }

            if(currentRow - 1 >= 0 && rooms[currentRow][currentCol] + 1 < rooms[currentRow - 1][currentCol]) {
                rooms[currentRow - 1][currentCol] = rooms[currentRow][currentCol] + 1;
                q.add(new int[]{currentRow - 1, currentCol});
            }
        }
    }
}

 
