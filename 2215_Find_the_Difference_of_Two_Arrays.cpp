
/*
    https://leetcode.com/problems/find-the-difference-of-two-arrays/description/
    
    Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
    answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
    Note that the integers in the lists may be returned in any order.

*/
class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        vector<vector<int>> ans(2);
        unordered_set<int> set1;
        unordered_set<int> set2;

        for(int num : nums1) {
            set1.insert(num);
        }

        for(int num : nums2) {
            set2.insert(num);
        }

        for(int num : set1) {
            if(set2.find(num) == set2.end()) {
                ans[0].push_back(num);
            }
        }

        for(int num : set2) {
            if(set1.find(num) == set1.end()){
                ans[1].push_back(num);
            }
        }

        return ans;
    }
};
