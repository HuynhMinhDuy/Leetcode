/*
Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
*/

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        for(int i = 1; i <= arr.length; ++i) {
            int currentMax = Integer.MIN_VALUE;
            int currentMaxSum = Integer.MIN_VALUE;

            for(int j = 1; j <= k && i - j >= 0; ++j) {
                currentMax = Math.max(currentMax, arr[i - j]);
                currentMaxSum = Math.max(currentMaxSum, dp[i - j] + currentMax * j);
            }
            dp[i] = currentMaxSum;
        }

        return dp[arr.length];
    }
}
