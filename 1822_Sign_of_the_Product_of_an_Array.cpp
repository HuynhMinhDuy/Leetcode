/*
  https://leetcode.com/problems/sign-of-the-product-of-an-array/description/
  
  There is a function signFunc(x) that returns:

  1 if x is positive.
  -1 if x is negative.
  0 if x is equal to 0.
  You are given an integer array nums. Let product be the product of all values in the array nums.

  Return signFunc(product).
*/

class Solution {
public:
    int arraySign(vector<int>& nums) {
        bool negative = true;

        for(int val : nums) {
            if(val == 0) return 0;
            if(val < 0) negative = !negative;
        }

        return negative == true ? 1 : -1;
    }
};
