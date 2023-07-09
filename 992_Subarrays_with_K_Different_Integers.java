
/*
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 
*/
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    public int atMostK(int[] nums, int k) {
        int numberSubarray = 0;
        int distict = 0;   
           
        Map<Integer, Integer> freq  = new HashMap<>();

        for(int start = 0, end = 0; end < nums.length; ++end) {
           
            freq.put(nums[end], freq.getOrDefault(nums[end], 0) + 1);
            if(freq.get(nums[end]) == 1) {
                    ++distict;
            }                    

            while(distict > k) {
                freq.put(nums[start], freq.get(nums[start]) - 1);
                if(freq.get(nums[start]) == 0) {
                    --distict;
                }
                ++start;
            }            
            numberSubarray += end - start + 1;           
        }
        return numberSubarray;
    }
}
