/*
https://leetcode.com/problems/is-subsequence/description
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
without disturbing the relative positions
of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

*/


class Solution {
public:
    bool isSubsequence(string s, string t) {

        int lenS = s.length();
        int lenT  = t.length();
        if(lenS == 0) return true;
        if(lenT < lenS) return false;

        int idxS = 0;
        int idxT = 0;

        while(idxT < lenT) {
            if(s[idxS] == t[idxT]) {
                ++idxS;
                if(idxS == lenS) {
                    return true;
                }
            }
            ++idxT;
        }
        return false;        

    }
};
