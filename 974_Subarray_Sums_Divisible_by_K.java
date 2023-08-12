/*
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.
*/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum  = 0;
        int ans = 0;
        int[] modK = new int[k];
        modK[0] = 1;
        for(int num : nums) {    
            // Take modulo twice to avoid negative remainders.
            sum = (sum + num % k + k) % k;            
            ans += modK[sum];
            ++modK[sum];
        }
        return ans;
    }
}
