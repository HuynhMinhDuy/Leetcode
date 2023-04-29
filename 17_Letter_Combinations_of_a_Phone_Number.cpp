class Solution {
public:
    void solve(string digits, vector<string>& ans, unordered_map<char, vector<char>> m, string tmp, int digit) {
            if(digit == digits.length()) {
                ans.push_back(tmp);
            } else {
                vector<char> chars = m[digits[digit]];
                for(char c : chars) {
                    tmp[digit] = c;
                    solve(digits, ans, m, tmp, digit + 1);
                }
            }
    }
    vector<string> letterCombinations(string digits) {
        unordered_map<char, vector<char>> m {
            {'2' , {'a', 'b', 'c'}},
            {'3' , {'d', 'e', 'f'}},
            {'4' , {'g', 'h', 'i'}},
            {'5' , {'j', 'k', 'l'}},
            {'6' , {'m', 'n', 'o'}},
            {'7' , {'p', 'q', 'r', 's'}},
            {'8' , {'t', 'u', 'v'}},
            {'9' , {'w','x', 'y', 'z'}}
        };
        vector<string> ans;
        string tmp(digits.length(), ' ');
        if(digits.length() > 0) solve(digits, ans, m, tmp, 0);
        return ans;
    }
};
