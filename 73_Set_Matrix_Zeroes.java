
/*
https://leetcode.com/problems/set-matrix-zeroes/description/

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.
*/


class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isSetZeroFirstRow = false;
        boolean isSetZeroFirstCol = false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int row = 0; row < rows; ++row) {
            for(int col = 0; col < cols; ++col) {
                if(matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                    if(row == 0) {
                        isSetZeroFirstRow = true;
                    }
                    if(col == 0) {
                        isSetZeroFirstCol = true;
                    }
                }
            }
        }
        
        for(int row = 1; row  < rows; ++row) {
            for(int col = 1; col < cols; ++col) {
                if(matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
       
        if(isSetZeroFirstRow == true) {
            for(int col = 0 ; col < cols; ++col) {
                matrix[0][col] = 0;
            }
        }

        if(isSetZeroFirstCol == true) {
            for(int row = 0; row < rows ; ++row) {
                matrix[row][0] = 0;
            }
        }

    }
}
