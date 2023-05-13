/*
  https://leetcode.com/problems/product-of-array-except-self/description
  Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

  The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

  You must write an algorithm that runs in O(n) time and without using the division operation.
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[nums.length];
        int leftProduct = 1;
        int rightProduct = 1;
        for(int i = len - 1; i >= 1; --i) {
            rightProduct *= nums[i];
            ans[i] = rightProduct;
        }

        for(int i = 0; i < len - 1; ++i) {
            ans[i]  = leftProduct * ans[i + 1];
            leftProduct *= nums[i];
        }
        ans[len - 1] = leftProduct;

        return ans;
    }
}
