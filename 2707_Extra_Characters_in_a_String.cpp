/*
You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.

Return the minimum number of extra characters left over if you break up s optimally.
*/

class Solution {
public:
    bool isMatch(string p, string s, int lastIndex) {
        if(lastIndex + 1 < p.length()) {
            return false;
        }
        int idxP = p.length() - 1;
        while(idxP >= 0){
            if(s[lastIndex] != p[idxP]){
                return false;
            }
            --idxP;
            --lastIndex;
        }
        return true;
    }

    int minExtraChar(string s, vector<string>& dictionary) {
        int len = s.length();
        vector<int> dp(len + 1, 0);

        for(int i = 0 ; i < len; ++i) {
            dp[i + 1] = dp[i] + 1;
            for(string dic : dictionary) {
                if(isMatch(dic, s, i)) {                    
                    dp[i + 1] = min(dp[i + 1], dp[ i - dic.length() + 1]);
                }
            }
        }

        return dp[len];
    }
};
