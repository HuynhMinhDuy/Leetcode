/*
https://leetcode.com/problems/longest-consecutive-sequence/description

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set  = new HashSet<>();
        int ans = 0;
        int count = 0;
        for(int num : nums) {
            set.add(num);
        }

        for(int num : set) {
            int val = num;
            if(!set.contains(val - 1)){
                while(set.contains(val)) {
                    ++count;
                    ++val;
                }
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        return ans;
    }
}
