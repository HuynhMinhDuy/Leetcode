/*
You are given an integer array nums containing distinct numbers, and you can perform the following operations until the array is empty:

If the first element has the smallest value, remove it
Otherwise, put the first element at the end of the array.
Return an integer denoting the number of operations it takes to make nums empty.
*/
class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        Map<Integer, Integer> pos = new HashMap<>();
        long ans = nums.length;
        for(int i = 0; i < nums.length; ++i){
            pos.put(nums[i], i);
        }
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; ++i) {
            if(pos.get(nums[i]) < pos.get(nums[i - 1])) {
                ans += nums.length - i;
            }
        }
        return ans;
    }
}
