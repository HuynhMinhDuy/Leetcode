

/*
You are given a 0-indexed integer array nums and an integer p. Find p pairs of indices of nums such that the maximum difference amongst all the pairs is minimized. Also, ensure no index appears more than once amongst the p pairs.

Note that for a pair of elements at the index i and j, the difference of this pair is |nums[i] - nums[j]|, where |x| represents the absolute value of x.

Return the minimum maximum difference among all p pairs. We define the maximum of an empty set to be zero.
*/

class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1000_000_001;
        int ans = 0;
        while(left <= right) {
            int diff = left + (right - left) / 2;
            if(canFindPairs(nums, diff, p) == true) {                
                ans = diff;
                right = diff - 1;
            } else {
                left = diff + 1;
            }
        }
        return ans;
    }
    public boolean canFindPairs(int[] nums, int diff, int p) {
        int count = 0; 
        int i = 1; 
        while(i < nums.length) {
            if((nums[i] - nums[i - 1]) <= diff) {
                ++count;
                i += 2;
            } else {
                ++i;
            }
        }        
        return count >= p ? true : false;
    }
}
