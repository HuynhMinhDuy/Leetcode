
/*

You are given an array nums consisting of positive integers.

We call a subarray of an array complete if the following condition is satisfied:

The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
Return the number of complete subarrays.

A subarray is a contiguous non-empty part of an array.
*/

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> m = new HashMap<>();
        int ans = 0;
        int distict = 0;
        int currentDistict = 0;
        for (int num : nums) {
            set.add(num);
        }

        distict = set.size();

        for(int start = 0, end = 0; end < nums.length; ++end) {
            m.put(nums[end], m.getOrDefault(nums[end], 0) + 1);
            if(m.get(nums[end]) == 1) {
                ++currentDistict;
            }

            while(currentDistict == distict) {
                m.put(nums[start], m.get(nums[start]) - 1);
                if(m.get(nums[start]) == 0) {
                    --currentDistict;
                }
                ++start;
            }
            ans += start;
        }

        return ans;
    }
}
