
/*
A string is considered beautiful if it satisfies the following conditions:

Each of the 5 English vowels ('a', 'e', 'i', 'o', 'u') must appear at least once in it.
The letters must be sorted in alphabetical order (i.e. all 'a's before 'e's, all 'e's before 'i's, etc.).
For example, strings "aeiou" and "aaaaaaeiiiioou" are considered beautiful, but "uaeio", "aeoiu", and "aaaeeeooo" are not beautiful.

Given a string word consisting of English vowels, return the length of the longest beautiful substring of word. If no such substring exists, return 0.

A substring is a contiguous sequence of characters in a string.
*/

class Solution {
    public int longestBeautifulSubstring(String word) {
        int distict = 1;
        int longestSubstring = 0;
        char currentSeqChar = word.charAt(0);

        for(int end = 0, start = 0; end < word.length(); ++end) {
            if(word.charAt(end) > currentSeqChar) {
                currentSeqChar = word.charAt(end);
                ++distict;
            } else if (word.charAt(end) < currentSeqChar) {
                currentSeqChar = word.charAt(end);
                start = end;
                distict = 1;
            }
            if(distict == 5) {                
                longestSubstring = Math.max(longestSubstring, end - start + 1);
            }
        }

        return longestSubstring;
    }
}
