/*
You are given a 0-indexed integer array nums of length n and an integer k. In an operation, you can choose an element and multiply it by 2.

Return the maximum possible value of nums[0] | nums[1] | ... | nums[n - 1] that can be obtained after applying the operation on nums at most k times.

Note that a | b denotes the bitwise or between two integers a and b.

*/

class Solution {
    public long maximumOr(int[] nums, int k) {
        long prefix = 0;
        long[] suffix = new long[nums.length + 1];        
        long ans = 0;
       
        for(int i = nums.length - 1; i >=0; --i) {
            suffix[i] = suffix[i + 1] | nums[i];
        }

        for(int i = 0; i < nums.length; ++i){
            long num = (long)nums[i];
            ans = Math.max(ans, num << k | prefix | suffix[i + 1]);
            prefix |= num;
        }
        
        return ans;
    }
}
