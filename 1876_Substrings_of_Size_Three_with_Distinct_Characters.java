/*
A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string. 

*/

class Solution {
    public int countGoodSubstrings(String s) {
        int goodSubString = 0;
        int[] freq = new int[26];
        int distict = 0;
        for(int start = 0, end = 0; end < s.length(); ++end) {
            ++freq[s.charAt(end) - 'a'];
            if(freq[s.charAt(end) - 'a'] == 1) {
                ++distict;
            }

            if(end + 1 >= 3) {
                if(distict == 3) {
                    ++goodSubString;
                }
                --freq[s.charAt(start) - 'a'];
                if(freq[s.charAt(start) - 'a'] == 0) {
                    --distict;
                }
                ++start;
            }
        }

        return goodSubString;
    }
}
