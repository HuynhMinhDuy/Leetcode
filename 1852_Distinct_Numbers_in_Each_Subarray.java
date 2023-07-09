/*
Given an integer array nums and an integer k, you are asked to construct the array ans of size n-k+1 where ans[i] is the number of distinct numbers in the subarray nums[i:i+k-1] = [nums[i], nums[i+1], ..., nums[i+k-1]].

Return the array ans.

*/

class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();
        for(int start = 0, end = 0; end < nums.length; ++end) {
            freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);
            if(end + 1 >= k) {
                ans[start] = freq.size();
                int freqStart = freq.get(nums[start]);
                if(freqStart == 1) {
                    freq.remove(nums[start]);
                } else {
                    freq.put(nums[start], freqStart - 1);
                }
                ++start;
            }
        }
        return ans;
    }
}
