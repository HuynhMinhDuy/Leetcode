/*
https://leetcode.com/problems/contains-duplicate-ii/description

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

*/

class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int,int> m;
        for(int i = 0; i < nums.size(); ++i) {
            if(m.find(nums[i]) != m.end()) {
                if ((i - m[nums[i]]) <= k) {
                    return true;
                }
            }
            m[nums[i]] = i;
        }

        return false;
    }
};
