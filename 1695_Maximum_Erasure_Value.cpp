/*
https://leetcode.com/problems/maximum-erasure-value/description/
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
*/

class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        vector<int> prefix_sum(nums.size() + 1, 0);
        unordered_map<int,int> m;
        int maxPos = -1;
        int ans = 0;                

        for(int i = 0; i < nums.size(); ++i) {
            
            prefix_sum[i + 1] = nums[i] + prefix_sum[i];
            
            if(m.find(nums[i]) != m.end()) {
                maxPos = max(maxPos, m[nums[i]]);
            }

            if (maxPos >= 0) {
                ans = max(ans, prefix_sum[i + 1] - prefix_sum[maxPos + 1]);
            } else {
                ans = max(ans, prefix_sum[i + 1]);
            }
            
            m[nums[i]] = i;
        }

        return ans;
    }
};
