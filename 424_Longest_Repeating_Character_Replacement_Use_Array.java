/*
https://leetcode.com/problems/longest-repeating-character-replacement/description/
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

*/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int longestSubstring = 0;
        int maxFreq = 0;
        for(int end = 0, start = 0; end < s.length(); ++end) {
            char charEnd = s.charAt(end);
            ++freq[charEnd - 'A'];
            maxFreq = Math.max(maxFreq, freq[charEnd - 'A']);
            if(end - start + 1 - maxFreq > k) {
                char charStart = s.charAt(start);
                --freq[charStart - 'A'];
                ++start;
            } else {
                longestSubstring = Math.max(longestSubstring, end - start + 1);
            }
        }
        return longestSubstring; 
    }
}
