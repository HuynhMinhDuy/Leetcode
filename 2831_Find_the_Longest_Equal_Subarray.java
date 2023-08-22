/*
You are given a 0-indexed integer array nums and an integer k.

A subarray is called equal if all of its elements are equal. Note that the empty subarray is an equal subarray.

Return the length of the longest possible equal subarray after deleting at most k elements from nums.

A subarray is a contiguous, possibly empty sequence of elements within an array.
*/
class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {

        Map<Integer, Integer> m = new HashMap<>();       
        int maxFreq = Integer.MIN_VALUE;
      
        for(int start = 0, end  = 0; end < nums.size(); ++end){
            m.put(nums.get(end), m.getOrDefault(nums.get(end), 0) + 1);
            int freqValue = m.get(nums.get(end));
            maxFreq = Math.max(maxFreq, freqValue);
            if((end - start + 1 - maxFreq > k)) {
               m.put(nums.get(start), m.get(nums.get(start)) - 1);            
               ++start;
            } 
        }

        return maxFreq;
    }
}
