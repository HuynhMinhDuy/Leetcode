/*
You are given a 0-indexed integer array nums. You have to find the maximum sum of a pair of numbers from nums such that the maximum digit in both numbers are equal.

Return the maximum sum or -1 if no such pair exists.
*/
class Solution {
    public int maxSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;

        for(int num : nums) {
            int digit = getDigit(num);
            int currentValue = map.getOrDefault(digit, 0);
            if(currentValue != 0) {
                ans = Math.max(ans, map.get(digit) + num);
            }
            if(currentValue == 0 || num > currentValue) {
                map.put(digit, num);
            }
        }

        return ans;
    }

    public int getDigit(int num) {
        int maxDigit = 0;
        while(num > 0) {
            maxDigit = Math.max(maxDigit, num % 10);
            num /= 10;
        }
        return maxDigit;
    }
}
