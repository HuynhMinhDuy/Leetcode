
/*
https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

A subarray is a contiguous non-empty sequence of elements within an array.
*/
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSubarraySum = 0;
        long currentSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for(int end = 0, start = 0; end < nums.length; ++end) {
            currentSum += nums[end];
            freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);
            if(end - start + 1 > k) {
                if(freq.get(nums[start]) == 1) {
                    freq.remove(nums[start]);
                } else {
                    freq.put(nums[start], freq.getOrDefault(nums[start], 0) - 1);
                }
                currentSum -= nums[start];
                ++start;
            }
            if(freq.size() == k) {
                maxSubarraySum = Math.max(maxSubarraySum, currentSum);
            }            
        }        
        return maxSubarraySum;
    }
}
