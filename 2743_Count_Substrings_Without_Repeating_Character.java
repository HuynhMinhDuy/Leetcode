/*
You are given a string s consisting only of lowercase English letters. We call a substring special if it contains no character which has occurred at least twice (in other words, it does not contain a repeating character). Your task is to count the number of special substrings. For example, in the string "pop", the substring "po" is a special substring, however, "pop" is not special (since 'p' has occurred twice).

Return the number of special substrings.

A substring is a contiguous sequence of characters within a string. For example, "abc" is a substring of "abcd", but "acd" is not.
*/

class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int[] pos = new int[26];
        int ans = 0;
        int maxPos = -1;
        Arrays.fill(pos, -1);

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            maxPos = Math.max(maxPos, pos[c - 'a']);
            ans += i - maxPos;
            pos[c - 'a'] = i;
        }

        return ans;
    }
}
