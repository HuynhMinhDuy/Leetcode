/*
You are given a 0-indexed integer array nums. You have to partition the array into one or more contiguous subarrays.

We call a partition of the array valid if each of the obtained subarrays satisfies one of the following conditions:

The subarray consists of exactly 2 equal elements. For example, the subarray [2,2] is good.
The subarray consists of exactly 3 equal elements. For example, the subarray [4,4,4] is good.
The subarray consists of exactly 3 consecutive increasing elements, that is, the difference between adjacent elements is 1. For example, the subarray [3,4,5] is good, but the subarray [1,3,5] is not.
Return true if the array has at least one valid partition. Otherwise, return false.
*/

class Solution {
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[3];
        dp[0] = true;
        for(int i = 1; i < nums.length; ++i) {
            boolean ans = false;
            int dpIdx = i + 1;

            if(nums[i] == nums[i - 1]) {
                ans |= dp[(dpIdx - 2) % 3]; 
            }

            if(i >= 2 && nums[i] == nums[i - 1] && nums[i] == nums[i -2]) {
                ans |= dp[(dpIdx - 3) % 3];
            }

            if(i >= 2 && nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i -2] + 1) {
                ans |= dp[(dpIdx - 3) % 3];
            }

            dp[dpIdx % 3] = ans;
        }

        return dp[nums.length % 3];
    }
}
