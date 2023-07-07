/*
Given an m x n picture consisting of black 'B' and white 'W' pixels, return the number of black lonely pixels.

A black lonely pixel is a character 'B' that located at a specific position where the same row and same column don't have any other black pixels.
*/

class Solution {
    public int findLonelyPixel(char[][] picture) {
        int rows = picture.length;
        int cols = picture[0].length;
        int ans = 0;
        int[] rowCheck = new int[rows];
        int[] colCheck = new int[cols];
        for(int row = 0; row < rows; ++row) {
            for(int col = 0; col < cols; ++col) {
                if(picture[row][col] == 'B') {
                    ++rowCheck[row];
                    ++colCheck[col];
                }
            }
        }
        for(int row = 0; row < rows; ++row) {
            for(int col = 0; col < cols; ++col) {
                if(picture[row][col] == 'B' && rowCheck[row] == 1 && colCheck[col] == 1) {
                    ++ans;
                }
            }
        }

        return ans;
    }
}
