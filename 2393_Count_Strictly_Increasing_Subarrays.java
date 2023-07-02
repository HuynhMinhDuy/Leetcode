/*
https://leetcode.com/problems/count-strictly-increasing-subarrays/description/
You are given an array nums consisting of positive integers.

Return the number of subarrays of nums that are in strictly increasing order.

A subarray is a contiguous part of an array.
*/
class Solution {
    public long countSubarrays(int[] nums) {
        long numberIncrSub = 1;
        int count = 1;
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] > nums[i - 1]) {
                ++count;
            } else {
                count = 1;
            }            
            numberIncrSub += count;
        }
        return numberIncrSub;
    }
}
