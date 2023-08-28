
/*
You are given a 0-indexed integer array nums. You are allowed to permute nums into a new array perm of your choosing.

We define the greatness of nums be the number of indices 0 <= i < nums.length for which perm[i] > nums[i].

Return the maximum possible greatness you can achieve after permuting nums.
*/
class Solution {
    public int maximizeGreatness(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int maxFreq = 0 ;
        for(int num : nums) {
            int freq = m.getOrDefault(num, 0) + 1;
            m.put(num, freq);
            maxFreq = Math.max(maxFreq, freq);
        }
        return nums.length - maxFreq;
    }
}
