/*
You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

*/

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();     
        map.put(0, 1);
        for(int num : nums) {
            Map<Integer, Integer> newMap = new HashMap<>();
            for(int sum : map.keySet()) {  
                int count = map.get(sum);             
                newMap.put(sum + num, newMap.getOrDefault(sum + num, 0) +  count); 
                newMap.put(sum - num, newMap.getOrDefault(sum - num, 0) +  count);           
            }
            map = newMap;
        }        
        return map.containsKey(target) ? map.get(target) : 0;
    }
}
