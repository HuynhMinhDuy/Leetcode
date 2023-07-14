
/*
Given an integer array nums containing distinct positive integers, find and return any number from the array that is neither the minimum nor the maximum value in the array, or -1 if there is no such number.

Return the selected integer.
 
*/
class Solution {
    public int findNonMinOrMax(int[] nums) {
        if(nums.length <= 2) return -1;
        int idxMin = 0;
        int idxMax = 0;
        int idx = 0;

        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] > nums[idxMax]) {
                idx = idxMax;
                idxMax = i;
            } else if(nums[i] < nums[idxMin]) {
                idx = idxMin;
                idxMin = i;            
            } else {
                idx = i;
            }                
        }
        return nums[idx];
    }
}
