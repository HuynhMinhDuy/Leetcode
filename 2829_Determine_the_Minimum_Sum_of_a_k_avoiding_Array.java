/*
You are given two integers, n and k.

An array of distinct positive integers is called a k-avoiding array if there does not exist any pair of distinct elements that sum to k.

Return the minimum possible sum of a k-avoiding array of length n.
*/

class Solution {
    public int minimumSum(int n, int k) {        
        int N = Math.min(k / 2, n) ;
        int sumLeft = (N * (N + 1)) / 2;
        int remain = n - N;
        int sumRight = 0 ;
        if(remain > 0) {
            sumRight = k * remain + (remain * (remain - 1) ) / 2;
        }       
        return sumLeft + sumRight; 
    }
}
