
/*
  Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

  A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.
*/
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> freq = new HashMap<>();
        int longestSubseq = 1;
        for(int num : arr) {
            int prevFreq = freq.getOrDefault(num - difference, 0);            
            freq.put(num, prevFreq + 1);
            longestSubseq = Math.max(longestSubseq, prevFreq + 1);
        }
        return longestSubseq;
    }
}
