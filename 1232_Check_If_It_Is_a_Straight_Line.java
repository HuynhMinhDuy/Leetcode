
/*
https://leetcode.com/problems/check-if-it-is-a-straight-line/description/
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {

        // y = m*x + c
        // m = (y2 - y1) / (x2 - x1)
        // c = y1 - m * x1
      
        int diffY  = coordinates[1][1] - coordinates[0][1];
        int diffX = coordinates[1][0] - coordinates[0][0];
        
        for(int point = 2; point < coordinates.length; ++point) {
            int diffYCurrentPoint = coordinates[point][1] - coordinates[point - 1][1];
            int diffXCurrentPoint = coordinates[point][0] - coordinates[point - 1][0];

            if(diffY * diffXCurrentPoint != diffX * diffYCurrentPoint) return false;
        }
        return true;        
    }
}
