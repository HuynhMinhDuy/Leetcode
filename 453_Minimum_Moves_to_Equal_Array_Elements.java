/*
Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

In one move, you can increment n - 1 elements of the array by 1.
 
*/
class Solution {
    public int minMoves(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        int ans = 0;
        for(int num : nums) {
            minValue = Math.min(minValue, num);
        }
        for(int num : nums) {
            ans += num - minValue;
        }
        return ans;
    }
}
