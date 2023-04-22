/*
  https://leetcode.com/problems/longest-substring-without-repeating-characters/
  Given a string s and an integer k, return the length of the longest 
   substring  of s that contains at most k distinct characters.
*/
class Solution {
public:
    int lengthOfLongestSubstringKDistinct(string s, int k) {
        int ans = 0;
        vector<int> m(256, 0);
        int numberChars = 0;

        for(int end = 0, start = 0; end < s.length(); ++end) {
            ++m[s[end]];
            if(m[s[end]] == 1) {
                ++numberChars;
            }

            if(numberChars <= k) {
                ans = max (ans, end - start + 1);
            } else {
                --m[s[start]];
                if (m[s[start]] == 0) {
                    --numberChars;
                }
                ++start;
            }
        }


        return ans;
    }
};
