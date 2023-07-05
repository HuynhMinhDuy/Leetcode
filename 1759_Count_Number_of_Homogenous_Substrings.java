/*
Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.

A string is homogenous if all the characters of the string are the same.

A substring is a contiguous sequence of characters within a string.

*/

class Solution {
    public int countHomogenous(String s) {
        int MOD = 1000000007;
        int numberHomoge = 0;

        int i = 0;
        while ( i < s.length()) {
            char c = s.charAt(i);
            int count = 0;
            while(i < s.length() && s.charAt(i) == c) {
                ++count;
                ++i;
                numberHomoge = (numberHomoge + count) % MOD;
            }
            count = 0;
        }
        return numberHomoge;
    }
}
