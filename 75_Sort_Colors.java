
/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
*/
class Solution {
    public void sortColors(int[] nums) {
        int idxZero = 0;
        int idxTwo = nums.length - 1;
        int idx = 0;

        while(idx <= idxTwo) {
          if(idxZero < idx && nums[idx] == 0) {
            nums[idx] = nums[idxZero];
            nums[idxZero] = 0;
            ++idxZero;
          } else if(nums[idx] == 2) {
            nums[idx] = nums[idxTwo];
            nums[idxTwo] = 2;
            --idxTwo;
          } else {
            ++idx;
          }
        }
    }
}
