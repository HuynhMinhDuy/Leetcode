/*
Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.

Note that:

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).

*/
 
class Solution {
    public int longestArithSeqLength(int[] nums) {
        int longestArith = 0;
        Map<Integer, Map<Integer, Integer>> numsDiff = new HashMap<>();

        for(int i = 0; i < nums.length; ++i) {
            Map<Integer, Integer> diffCount = new HashMap<>();            
            for(int j = i - 1; j >= 0 ; --j) {
                Map<Integer, Integer> prevDiffCount = numsDiff.get(j);
                int diff = nums[i] - nums[j];
                if(!diffCount.containsKey(diff)) {
                    diffCount.put(diff, prevDiffCount.getOrDefault(diff, 0) + 1);
                }                
                longestArith = Math.max(longestArith, diffCount.get(diff));
            }           
            numsDiff.put(i, diffCount);            
        }
        return longestArith + 1;
    }
}
