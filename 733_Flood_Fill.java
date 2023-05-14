/*
    https://leetcode.com/problems/flood-fill/description/
    An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

    You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].

    To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.

    Return the modified image after performing the flood fill.

*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originColor = image[sr][sc];
        if(originColor != color ) DFS(image, sr, sc, originColor, color);
        return image;
    }

    public void DFS(int[][] image, int x, int y, int originColor, int color) {
        image[x][y] = color;
        if(x + 1 < image.length && image[x + 1][y] == originColor)  {
            DFS(image, x + 1, y, originColor, color);
        }
        if(x - 1 >= 0 && image[x - 1][y] == originColor) {
             DFS(image, x - 1, y, originColor, color);
        }
        if(y + 1 < image[0].length && image[x][y + 1] == originColor)  {
            DFS(image, x, y + 1, originColor, color);
        }
        if(y - 1 >= 0 && image[x][y - 1] == originColor) {
             DFS(image, x, y - 1, originColor, color);
        }
    }
}
