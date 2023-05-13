
/*
https://leetcode.com/problems/length-of-last-word/description

Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring  consisting of non-space characters only.
 
*/
class Solution {
    public int lengthOfLastWord(String s) {
        int lastIndex = s.length() - 1;
        int lengthLastWord = 0;

        while(lastIndex >= 0 && s.charAt(lastIndex) == ' ') {
            --lastIndex;
        }

        while(lastIndex >= 0 && s.charAt(lastIndex) != ' ') {
            --lastIndex;
            ++lengthLastWord;
        }

        return lengthLastWord;
    }
}
