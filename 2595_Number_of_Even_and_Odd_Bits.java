/*
You are given a positive integer n.

Let even denote the number of even indices in the binary representation of n (0-indexed) with value 1.

Let odd denote the number of odd indices in the binary representation of n (0-indexed) with value 1.

Return an integer array answer where answer = [even, odd].
*/

class Solution {
    public int[] evenOddBit(int n) {
        int even = 0;
        int odd = 0;
        for(int i = 0; i <= 31; ++i) {
            int bit = (n >>> i) & 1;
            if(bit == 1) {
                if(i % 2 == 0) {
                    ++even;
                } else {
                    ++odd;
                }
            }
        }
        return new int[]{even, odd};
    }
}
