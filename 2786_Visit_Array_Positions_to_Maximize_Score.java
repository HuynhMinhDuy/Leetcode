class Solution {
    public long maxScore(int[] nums, int x) {

        long[] dp = {-x, -x};       
        dp[nums[0] & 1] = nums[0];
        for(int i = 1; i < nums.length; ++i) {
            dp[nums[i] & 1] = Math.max(dp[nums[i] & 1], dp[(nums[i] & 1 ) ^ 1] - x) + nums[i];            
        }     
        return Math.max(dp[0], dp[1]);
    }
}
