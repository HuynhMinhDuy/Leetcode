/*
    https://leetcode.com/problems/majority-element/description
    
    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

*/

class Solution {
    public int majorityElement(int[] nums) {
        int majorNumber  = nums[0];
        int count = 0;
        for(int num : nums) {
            if(num == majorNumber) {
                ++count;
            } else {
                --count;
                if( count < 0) {
                    majorNumber = num;
                    count = 1;
                }
            }
        }

        return majorNumber;
    }
}
