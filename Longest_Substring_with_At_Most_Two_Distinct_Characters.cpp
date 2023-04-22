class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        int numberChars = 0;
        vector<int> m(256, 0);
        int ans = 0;

        for(int end = 0, start = 0; end < s.length(); ++end) {
            ++m[s[end]];
            if(m[s[end]] == 1) {
                ++numberChars;
            }
            if(numberChars <= 2) {
                ans = max(ans, end - start + 1);
            } else {
                --m[s[start]];
                if(m[s[start]] == 0) {
                    --numberChars;
                }
                ++start;
            }
        }

        return ans;
    }
};
