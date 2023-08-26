/*
You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.
*/

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int longestChain = 0;
        int minEnd = Integer.MIN_VALUE;

        for(int[] pair : pairs) {
            int begin = pair[0];
            int end = pair[1];
            if(minEnd < begin) {
                ++longestChain;
                minEnd = end;
            } else {
                minEnd = Math.min(minEnd, end);
            }
        }
        return longestChain;
    }
}
