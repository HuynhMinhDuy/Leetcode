/*
  https://leetcode.com/problems/rotate-array/description
  Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
*/
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    public void rotate(int[] nums, int start, int end) {
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            ++start;
            --end;
        }
    }
}
