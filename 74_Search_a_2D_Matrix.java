
/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int searchRow = binarySearchLastCol(matrix, target);

        if(searchRow == rows) return false;
        
        int left = 0 ;
        int right = cols - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[searchRow][mid] == target) {
                return true;
            } else if (matrix[searchRow][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public int binarySearchLastCol(int[][] matrix, int target) {
        int lastCol = matrix[0].length - 1;
        int left = 0; 
        int right  = matrix.length - 1;
        int ans = matrix.length;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[mid][lastCol] < target) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        return ans;
    }
}
