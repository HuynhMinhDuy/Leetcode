
/*
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int pro = 1;
        int ans = 0;
        for(int end = 0, start = 0; end < nums.length; ++end) {
            pro *= nums[end];
            while(start <= end && pro >= k) {
                pro /= nums[start];
                ++start;
            }
            ans += end - start + 1;
        }
        return ans;
    }
}
