
/*
Given a character array s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.

Your code must solve the problem in-place, i.e. without allocating extra space.
*/

class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        for(int i = 0, j = 0; i <= s.length; ++i) {
            if(i == s.length || s[i] == ' ') {
                reverse(s, j, i -1);
                j = i + 1;
            }
        }
    }

    public void reverse(char[] s, int start, int end) {
        while(start < end) {
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            ++start;
            --end;
        }
    }
}
