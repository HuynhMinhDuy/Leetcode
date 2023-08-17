
/*
You are given two integers num1 and num2.

In one operation, you can choose integer i in the range [0, 60] and subtract 2i + num2 from num1.

Return the integer denoting the minimum number of operations needed to make num1 equal to 0.

If it is impossible to make num1 equal to 0, return -1.
*/

class Solution {
    public int makeTheIntegerZero(int num1, int num2) {        
        for(int k = 1; k <= 60; ++k) {
            long num = num1 - (long)num2 * k;
            int numberOfBits = Long.bitCount(num);
            if(numberOfBits <= k && k <= num) {
                return k;
            }
        }
        return -1;
    }
}
