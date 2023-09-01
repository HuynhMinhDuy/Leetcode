/*
There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.

You may assume that the borders of the maze are all walls (see examples).
*/

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int []> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty()) {

            int[] currentPos = q.poll();
            int posX = currentPos[0];
            int posY = currentPos[1];     

            if(posX == destination[0] && posY == destination[1]) {
                return true;
            }    

            for(int[] move : moves) {                
                int nextPosX = posX;
                int nextposY = posY;    
                int moveX = move[0];
                int moveY = move[1];                
                while((nextPosX + moveX >= 0) && (nextPosX + moveX < rows) && (nextposY + moveY >= 0) && (nextposY + moveY < cols) && (maze[nextPosX + moveX][nextposY + moveY] == 0)) {
                    nextPosX += moveX;
                    nextposY += moveY;
                }

                if(visited[nextPosX][nextposY] == false) {                   
                    visited[nextPosX][nextposY] = true;
                    q.add(new int[]{nextPosX, nextposY});
                }
            }  

        }

        return false;
    }
}
