class Solution {
    private boolean ans = false;
    public boolean canCross(int[] stones) {

        boolean[][] visited = new boolean[2001][2001];

        // store value , index;
        Map<Integer, Integer> mask  = new HashMap<>();       

        for(int i = 0; i < stones.length; ++i) {
            mask.put(stones[i], i);
        }
        solve(stones, visited, mask, 0, 0);
        return ans;
    }

    public void solve(int[] stones, boolean[][] visited, Map<Integer, Integer> mask, int idx, int prevJump) {
        int n = stones.length;
        visited[idx][prevJump] = true;
        if(idx == n - 1) {
            ans = true;
            return;
        }
        for(int nextJump = prevJump - 1; nextJump <=  prevJump + 1; ++nextJump) {
            if (nextJump > 0 && mask.containsKey(stones[idx] + nextJump)) {
                int nextIdx = mask.get(stones[idx] + nextJump);
                if(visited[nextIdx][nextJump] == false && ans == false)  {
                    solve(stones, visited, mask, nextIdx, nextJump);
                }
            }
        }
        
    }
}
