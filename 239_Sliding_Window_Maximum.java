/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
       
        for(int start = 0, end = 0; end < nums.length; ++end) {
            while(!deque.isEmpty() && deque.getLast() < nums[end]) {
                deque.pollLast();
            }
            deque.addLast(nums[end]);            
            if(end >= k - 1) {
                ans[start] = deque.getFirst();
                if(nums[start] == deque.getFirst()) {
                    deque.pollFirst();
                }
                ++start;
            }
        }
        return ans;
    }
}
