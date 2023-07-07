/*
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int num : nums) {
            int sz = ans.size();
            for(int i = 0; i < sz; ++i) {
                List<Integer> newList = new ArrayList<>(ans.get(i));
                newList.add(num);
                ans.add(newList);
            }
        }
        return ans;
    }
}
