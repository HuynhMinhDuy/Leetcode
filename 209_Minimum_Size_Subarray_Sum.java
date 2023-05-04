/*
  https://leetcode.com/problems/minimum-size-subarray-sum/description/
  
  Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray
  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        for(int start = 0, end = 0; end < nums.length; ++end) {
            sum += nums[end];
             while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                ++start;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
