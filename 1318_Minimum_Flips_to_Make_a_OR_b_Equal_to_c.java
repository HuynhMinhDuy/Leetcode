/*
https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/

Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
*/

class Solution {
    public int minFlips(int a, int b, int c) {
        int minFlip = 0;

        for(int i = 0; i < 32; ++i) {
            
            int bitA = getKthBit(a, i);
            int bitB = getKthBit(b, i);
            int bitC = getKthBit(c, i);

            if(bitC == 0) {
                minFlip += bitA + bitB;
            } else {
                if(bitA == 0 && bitB == 0){
                    minFlip += 1;
                }
            }
        }
        return minFlip;
    }

    public int getKthBit(int n, int k) {        
        n &= 1 << k;
        return n > 0 ? 1 : 0;
    }
}
