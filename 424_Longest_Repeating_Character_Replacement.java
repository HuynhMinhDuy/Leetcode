/*
https://leetcode.com/problems/longest-repeating-character-replacement/description/
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

*/

class Solution {
    public int characterReplacement(String s, int k) {
        int longestSubstring  = 0;
        int maxFreq  = 0;
        Map<Character, Integer> m = new HashMap<>();

        for(int end = 0, start = 0; end < s.length(); ++end){
            char charEnd = s.charAt(end);
            m.put(charEnd, m.getOrDefault(charEnd, 0) +1);
            maxFreq = Math.max(maxFreq, m.get(charEnd));
            if((end - start + 1 - maxFreq) > k) {
                char charStart = s.charAt(start);
                m.put(charStart, m.get(charStart) - 1);
                ++start;
            } else {
                longestSubstring = Math.max(longestSubstring, end - start + 1);
            }
        }

        return longestSubstring;
    }
}
