
/*
A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.

Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.
*/

class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        st.push(0);
        for(int i = 1; i < nums.length; ++i) {
            if(nums[i] < nums[st.peek()]) {
                st.push(i);
            }
        }
        int idx = nums.length - 1;
        while(!st.isEmpty() && idx >= 0) {
            if(nums[idx] >= nums[st.peek()]) {
                ans = Math.max(ans, idx - st.peek());
                st.pop();
            } else {
                --idx;
            }
        }
        
        return ans;
    }
}
