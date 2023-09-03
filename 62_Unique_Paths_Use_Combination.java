
/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
*/

class Solution {
    public int uniquePaths(int m, int n) {
        // C(n,k) = n! / (k! * (n - k) !)
        int N = m + n - 2;
        int k = Math.min(m - 1, n - 1);
        long ans = 1;
        long leftPro = 1;

        long minValue = Math.min(N - k, k);

        for(long i = N - minValue + 1, j = 1; i <= N ; ++i, ++j) {
            if(i % j == 0) {
                ans *= i / j;
            } else {
                ans *= i;
                leftPro *= j;
            }

            if(ans % leftPro == 0) {
                ans /= leftPro;
                leftPro = 1;
            }
        }

        return (int)(ans / leftPro);
    }
}
