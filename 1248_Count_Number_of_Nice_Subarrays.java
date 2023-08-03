
/*
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.
*/
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> m  = new HashMap<>();
        int prefixSum = 0;
        int ans = 0;
        m.put(0, 1);

        for(int num : nums) {
            if(num % 2 != 0) {
                ++prefixSum;
            }
            if(m.containsKey(prefixSum - k)) {
                ans += m.get(prefixSum - k);
            }
            m.put(prefixSum, m.getOrDefault(prefixSum, 0) + 1);
        }        
        return ans;
    }
}
