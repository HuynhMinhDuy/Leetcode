/*
The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.
  */

class Solution {
    public int maxFrequency(int[] nums, int k) {

        if(nums.length == 1) return 1;
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        Arrays.sort(nums);
        
        for(int wStart = 0, wEnd = 1; wEnd < nums.length; ++wEnd) {
            if(nums[wEnd] > nums[wEnd - 1]) {
                sum += (nums[wEnd] - nums[wEnd - 1]) * (wEnd - wStart);
            }
            while(sum > k) {
                sum -= nums[wEnd] - nums[wStart];
                ++wStart;
            }
            ans = Math.max(ans, wEnd - wStart + 1);
        }
        return ans;
    }
}
  
