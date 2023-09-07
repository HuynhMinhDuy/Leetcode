/*
You are given positive integers n and target.

An array nums is beautiful if it meets the following conditions:

nums.length == n.
nums consists of pairwise distinct positive integers.
There doesn't exist two distinct indices, i and j, in the range [0, n - 1], such that nums[i] + nums[j] == target.
Return the minimum possible sum that a beautiful array could have modulo 109 + 7.
*/
class Solution {
public:
    int minimumPossibleSum(int n, int target) {
        int MOD = 1000000007;
        int numberLeft = target / 2;
        long sumLeft  = 0;
        if(n <= numberLeft) {
            sumLeft = (long)n * (n + 1) / 2;
            return sumLeft % MOD;
        }

        sumLeft = (long)numberLeft * (numberLeft + 1) / 2;
        int remain = n - numberLeft;
        long sumRight = ((long)target *  remain) + ((long)remain * (remain - 1) / 2);

        return (int) ((sumLeft % MOD + sumRight % MOD) % MOD);
    }
};
