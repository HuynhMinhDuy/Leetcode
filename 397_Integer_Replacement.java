
/*
Given a positive integer n, you can apply one of the following operations:

If n is even, replace n with n / 2.
If n is odd, replace n with either n + 1 or n - 1.
Return the minimum number of operations needed for n to become 1.
*/

class Solution {
    public int integerReplacement(int n) {
        int ans = 0;
        long N = (long) n;

        while(N != 1) {
            if(N % 2 == 0) {
                N /= 2;
            } else {
                if (((N - 1) / 2 ) % 2 == 0 || ((N - 1) / 2) == 1) {
                    --N;
                } else {
                    ++N;
                }
            }
            ++ans;
        }
        return ans;
    }
}
