/*
  https://leetcode.com/problems/longest-palindromic-substring/description/
  
  Given a string s, return the longest palindromic substring in s.
  
*/

class Solution {
public:
    vector<int> extendMid(string s, int l, int r) {
        while (l >=0 && r < s.length() && s[l] == s[r]) {
            --l;
            ++r;
        }
        return { l + 1, r - 1};
    }

    string longestPalindrome(string s) {
        int maxLen = 0;
        int l = 0; 
        int r = 0;

        for(int i = 0; i < s.length(); ++i) {
            vector<int> extend1 = extendMid(s, i, i);
            vector<int> extend2 = extendMid(s, i, i + 1);
            if(extend1[1] - extend1[0] + 1 > maxLen) {
                l = extend1[0];
                r = extend1[1];                
            }
            if(extend2[1] - extend2[0] + 1 > maxLen) {
                l = extend2[0];
                r = extend2[1];               
            }
            maxLen = max(maxLen, r - l + 1);
        }

        return s.substr(l, r - l + 1);
    }
};
