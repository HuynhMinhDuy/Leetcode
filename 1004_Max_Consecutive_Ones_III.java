/*
  https://leetcode.com/problems/max-consecutive-ones-iii/description/
  Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int oneCount = 0;
        int maxOne = 0;
        for(int end = 0, start = 0; end < nums.length; ++end) {
            if(nums[end] == 1) {
                ++oneCount;
            }
            if(end - start + 1 - oneCount > k) {
                if(nums[start] == 1) {
                    --oneCount;
                }
                ++start;
            } else {
                maxOne = Math.max(maxOne, end - start + 1);
            }
        }

        return maxOne;
    }
}
