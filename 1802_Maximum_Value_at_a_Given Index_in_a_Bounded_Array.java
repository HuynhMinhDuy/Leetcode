/*
You are given three positive integers: n, index, and maxSum. You want to construct an array nums (0-indexed) that satisfies the following conditions:

nums.length == n
nums[i] is a positive integer where 0 <= i < n.
abs(nums[i] - nums[i+1]) <= 1 where 0 <= i < n-1.
The sum of all the elements of nums does not exceed maxSum.
nums[index] is maximized.
Return nums[index] of the constructed array.

Note that abs(x) equals x if x >= 0, and -x otherwise.
*/

class Solution {
    public int maxValue(int n, int index, int maxSum) {
     
        int left = 0;
        int right = maxSum;
        while (left <= right) {
            int val = left + (right - left) / 2;
            long sumLeft = getMinSum(val - 1, index);
            long sumRight = getMinSum(val - 1, n - index -1);            
            if((val + sumLeft +sumRight) <= maxSum) {
                left = val + 1;
            } else {
                right  = val - 1;
            }
        }        
        return right;
    }
    public long getMinSum(long val, long n) {        
        
        if( n <= 0 || val <= 0) return 0;

        if(val == n) {
            return n * (n + 1) / 2;
        } else if (val > n) {
            long m = val - n;
           return  (val * (val + 1) - m * (m  + 1)) / 2;
        }
        // val  < n
        long m = n  - val;
        return val * (val + 1) / 2 + m;
    }
}
