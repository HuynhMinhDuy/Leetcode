/*
Given two sparse matrices mat1 of size m x k and mat2 of size k x n, return the result of mat1 x mat2. You may assume that multiplication is always possible.
*/

class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {

        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;
        int[][] ans = new int[m][n];

        for(int row = 0; row < ans.length; ++row) {
            for(int col = 0; col < ans[0].length; ++col) {
                for(int i = 0; i < mat1[0].length; ++i) {
                    ans[row][col] += mat1[row][i] * mat2[i][col];
                }
            }
        }

        return ans;
    }
}
