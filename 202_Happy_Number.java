/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

 */

class Solution {
    public boolean isHappy(int n) {

        int fast = n;
        int slow = n;
        fast = squareSum(squareSum(fast));
        slow = squareSum(slow);

        while (fast != slow) {
            fast = squareSum(squareSum(fast));
            slow = squareSum(slow);
        }

        return fast == 1 ? true : false;
    }

    public int squareSum(int n) {
        int squareSum = 0; 
        while(n > 0) {
            int lastDigit = n % 10;
            squareSum += lastDigit * lastDigit;
            n /= 10;
        }
        return squareSum;
    }
}
