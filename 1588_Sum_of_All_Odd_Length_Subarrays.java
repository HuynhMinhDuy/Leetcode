
/*
Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.

A subarray is a contiguous subsequence of the array.
*/
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        int prefixSum = 0;
        int prefixSumEven = 0;
        int prefixSumOdd = 0;
        int countOdd = 0;
        int countEven = 0;
        
        for(int i = 0; i < arr.length; ++i) {
            prefixSum += arr[i];
            if(i % 2 == 0) {
              ++countEven;
              prefixSumEven += prefixSum;
              ans += prefixSum * (countOdd + 1) - prefixSumOdd;
            } else {
              ++countOdd;
              prefixSumOdd += prefixSum;
              ans += prefixSum * countEven - prefixSumEven;
            }
        }
        return ans;
    }
}
