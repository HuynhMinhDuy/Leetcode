/*
https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
*/

class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int row = 0;
        int col = cols - 1;

        int numberNegative = 0;

        while(row < rows && col >= 0) {
            if(col - 1 >= 0 && grid[row][col - 1] < 0) {
                --col;
            } else {
                if(grid[row][col] < 0) {
                    numberNegative += cols - col;
                }
                ++row;
            }
        }        
        return numberNegative;
    }
}
