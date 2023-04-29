class Solution {
public:
    void solve (vector<string>& ans, string tmp, int n, int open, int close) {
        if(open + close == 2*n) {
            ans.push_back(tmp);
        } else {
            if(open < n) {                
                tmp[open + close] = '(';
                solve(ans, tmp, n, open + 1, close);
            } 
            if(close < open) {
                tmp[open + close] = ')';
                solve(ans, tmp, n , open, close + 1);
            }
        }
    }
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        string tmp(2*n, ' ');
        solve(ans, tmp, n, 0, 0);
        return ans;
    }
};
