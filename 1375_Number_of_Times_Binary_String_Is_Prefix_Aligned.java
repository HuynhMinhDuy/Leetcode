
/*
You have a 1-indexed binary string of length n where all the bits are 0 initially. We will flip all the bits of this binary string (i.e., change them from 0 to 1) one by one. You are given a 1-indexed integer array flips where flips[i] indicates that the bit at index i will be flipped in the ith step.

A binary string is prefix-aligned if, after the ith step, all the bits in the inclusive range [1, i] are ones and all the other bits are zeros.

Return the number of times the binary string is prefix-aligned during the flipping process.
*/

class Solution {
    public int numTimesAllBlue(int[] flips) {
        int currentMax = Integer.MIN_VALUE;
        int numTimesAllBlue = 0;

        for(int i = 0; i < flips.length; ++i) {
            currentMax = Math.max(currentMax, flips[i]);
            if(currentMax == i + 1) {
                ++numTimesAllBlue;
            }
        }

        return numTimesAllBlue;
    }
}
