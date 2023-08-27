/*
A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
*/
class Solution {
    public boolean canCross(int[] stones) {
        int[][] dp = new int[2001][2001];

        // store value , index;
        Map<Integer, Integer> mask  = new HashMap<>();

        for(int i = 0 ; i < dp.length; ++i){
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < stones.length; ++i) {
            mask.put(stones[i], i);
        }

        return solve(stones, dp, mask, 0, 0);
    }

    public boolean solve(int[] stones, int[][]dp, Map<Integer, Integer> mask, int idx, int prevJump) {
        int n = stones.length;
        if(idx == n - 1) {
            return true;
        }

        if(dp[idx][prevJump] != -1) {
            return dp[idx][prevJump] == 1 ? true : false;
        }

        boolean ans = false;

        for(int nextJump = prevJump - 1; nextJump <=  prevJump + 1; ++nextJump) {
            if (nextJump > 0 && mask.containsKey(stones[idx] + nextJump)) {
                ans = ans || solve(stones, dp, mask, mask.get(stones[idx] + nextJump), nextJump);
            }
        }
        if(ans == true) {
            dp[idx][prevJump] = 1;
        } else {
            dp[idx][prevJump] = 0;
        }

        return ans;
    }
}
