/*
https://leetcode.com/problems/maximum-product-subarray/description
Given an integer array nums, find a subarray
that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.
*/

class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int ans = nums[0];
        int productLeft = 0;
        int productRight = 0;
        for(int i = 0; i < nums.size(); ++i) {
            productLeft = (productLeft == 0 ? 1 : productLeft) * nums[i];
            productRight = (productRight == 0 ? 1 : productRight) * nums[nums.size() - 1 - i];
            ans = max(ans, max(productLeft,productRight));
        }
        return ans;
    }
};
