
/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
*/
class Solution {
    public int[] countBits(int n) {
        int[] countBits = new int[n + 1];
        for(int i = 1; i <= n; ++i) {
            if(i % 2 == 0) {
                countBits[i] = countBits[i >> 1];
            } else {
                countBits[i] = countBits[i - 1]  + 1;
            }
        }      

        return countBits;
    }
}
