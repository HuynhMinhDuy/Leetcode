/*
Given an array of integers nums and a positive integer k, check whether it is possible to divide this array into sets of k consecutive numbers.

Return true if it is possible. Otherwise, return false.
*/

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : nums) {
            if(map.get(num) > 0) {
                boolean match = isMatch(nums, num, map, k);
                if(match == false) {
                    return false;
                }
            }
        }

        return true;
    }


    public boolean isMatch(int[] nums, int num, Map<Integer, Integer> map, int k) {

        while (k > 0) {
            if(!map.containsKey(num) || map.get(num) == 0) {
                return false;
            } 
            map.put(num, map.get(num) - 1);
            --k;
            ++num;
        }
        return true;
    }
}
