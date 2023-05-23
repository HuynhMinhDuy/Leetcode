/*
https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
*/

class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int ans = 0;
        int countZero = 0;
        for(int end = 0, start = 0; end < nums.size(); ++end){
            if(nums[end] == 0) {
                ++countZero;
            }
            if(countZero >= 2) {
                if(nums[start] == 0) {
                    --countZero;
                }
                ++start;
            } else {
                ans = max(ans, end - start);
            }            
        }
        return ans;
    }
};
