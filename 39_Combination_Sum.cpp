
/*
https://leetcode.com/problems/combination-sum/description/
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

*/
class Solution {
public:
    void solve(vector<vector<int>>& ans, vector<int> tmp, vector<int>& candidates, int target, int sum, int i) {  
        if(sum > target) return;
        if(sum == target) {
            ans.push_back(tmp);
        } else {
            for(int j = i; j < candidates.size(); ++j) {
                tmp.push_back(candidates[j]);
                solve(ans, tmp, candidates, target, sum + candidates[j], j);
                tmp.pop_back();
            }
        }
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        int sum = 0;
        vector<int> tmp;

        solve(ans, tmp, candidates, target, sum, 0);

        return ans;
    }
};
