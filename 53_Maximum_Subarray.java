/*
Given an integer array nums, find the 
subarray with the largest sum, and return its sum.
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int num : nums){
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            currentSum = Math.max(currentSum, 0);
        }

        return maxSum;
    }
}
