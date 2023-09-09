/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.
*/

class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        return solve(nums, map, target); 
    }

    public int solve (int []nums, Map<Integer, Integer> map, int remain) {
        
        if(remain == 0) {
            return 1;
        }

        if(map.containsKey(remain)) {
            return map.get(remain);
        }
        int result = 0;
        for(int num : nums) {
            if(remain >= num) {
                result += solve(nums, map, remain - num);
            }
        }
        map.put(remain, result);
        return result;
    }
}
