/*
You are given a 0-indexed string s that consists of digits from 0 to 9.

A string t is called a semi-repetitive if there is at most one consecutive pair of the same digits inside t. For example, 0010, 002020, 0123, 2002, and 54944 are semi-repetitive while 00101022, and 1101234883 are not.

Return the length of the longest semi-repetitive substring inside s.

A substring is a contiguous non-empty sequence of characters within a string.
*/
class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int count = 0;
        int ans = 1;
        for(int start = 0, end = 1; end < s.length(); ++ end) {
            if(s.charAt(end) == s.charAt(end - 1)) {
                ++count;
            }
            if(count >= 2) {
                if(s.charAt(start) == s.charAt(start + 1)) {
                    --count;
                }
                ++start;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
