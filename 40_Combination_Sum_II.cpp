/*
https://leetcode.com/problems/combination-sum-ii/description/

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

*/

class Solution {
public:
    void solve (vector<vector<int>>& ans,  vector<int>& candidates, int target, vector<int> tmp, int sum, int i ) {
        if(sum > target) return;
        if (sum == target) {
            ans.push_back(tmp);
        } else {
            for(int j = i; j < candidates.size() ; ++j) {
                if(j > i && candidates[j] == candidates[j -1]) continue; 
                tmp.push_back(candidates[j]);
                solve(ans, candidates, target,tmp,  sum + candidates[j], j + 1);
                tmp.pop_back();
            }
        }
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        int sum = 0;
        vector<int> tmp;

        sort(candidates.begin(), candidates.end());

        solve(ans, candidates, target, tmp, sum, 0);

        return ans;
    }
};
