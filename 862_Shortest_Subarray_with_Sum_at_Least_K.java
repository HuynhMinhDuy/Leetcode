

/*
Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.

A subarray is a contiguous part of an array.
*/

class Solution {
    public int shortestSubarray(int[] nums, int k) {

        long[] prefixSum = new long[nums.length];
        Deque<Integer> dq = new ArrayDeque<>();
        long sum = 0;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; ++i) {

            sum += nums[i];            
            if(sum >= k) {
                ans = Math.min(ans, i + 1);
            }

            while(!dq.isEmpty() && sum - prefixSum[dq.getFirst()] >= k) {
                ans = Math.min(ans, i - dq.getFirst());
                dq.removeFirst();
            }

            while(!dq.isEmpty() && sum <= prefixSum[dq.getLast()]) {
                dq.removeLast();
            }

            prefixSum[i] = sum;
            dq.addLast(i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
