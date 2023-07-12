/*
Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.

The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
*/
class Solution {
    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return GCD(min, max);
    }

    public int GCD(int p, int q) {
        if(p % q == 0) return q;
        return GCD(q, p % q);
    }
}
