/*
https://leetcode.com/problems/jump-game/description
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
*/

class Solution {
    public boolean canJump(int[] nums) {
        int maxPos = 0;

        for(int i = 0 ; i < nums.length; ++i) {
            if(i <= maxPos){
                maxPos = Math.max(maxPos, nums[i] + i); 
            }            
        }

        return maxPos >= nums.length - 1 ? true : false;
    }
}
