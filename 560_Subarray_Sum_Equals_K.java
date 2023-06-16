/*

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int totalSubArray = 0;
        int sum = 0;
        Map<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1);
        for(int num : nums) {
            sum += num;
            if(sumFreq.containsKey(sum - k)) {
                totalSubArray += sumFreq.get(sum - k);
            }
            sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
        }
        return totalSubArray;
    }
}
