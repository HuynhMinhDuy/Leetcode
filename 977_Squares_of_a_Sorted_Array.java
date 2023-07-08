/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int[] square = new int[nums.length];
        int idx = nums.length - 1;
        while(idx >= 0) {
            if(Math.abs(nums[l]) > Math.abs(nums[r])) {
                square[idx] = nums[l] * nums[l];
                ++l;
            } else {
                square[idx] = nums[r] * nums[r];
                --r;
            }
            --idx;
        }
        return square;
    }
}
