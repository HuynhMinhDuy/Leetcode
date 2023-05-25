/*

https://leetcode.com/problems/sum-in-a-matrix/description/
You are given a 0-indexed 2D integer array nums. Initially, your score is 0. Perform the following operations until the matrix becomes empty:

From each row in the matrix, select the largest number and remove it. In the case of a tie, it does not matter which number is chosen.
Identify the highest number amongst all those removed in step 1. Add that number to your score.
Return the final score.
*/

class Solution {
public:

    struct Comparator {
        bool operator()(int a, int b) {
            return a > b;  // Sort in descending order
            }
    };

    int matrixSum(vector<vector<int>>& nums) {
        int sum = 0;
        // Sorting each row in descending order
        for (auto& row : nums) {
            sort(row.begin(), row.end(), Comparator());
        }

        for (int col = 0; col < nums[0].size(); ++col) {
            int maxCol = 0;
            for (int row = 0; row < nums.size(); ++row) {
                maxCol = max(maxCol, nums[row][col]);
            }            
            sum += maxCol;
        }

        return sum;
    }
};
