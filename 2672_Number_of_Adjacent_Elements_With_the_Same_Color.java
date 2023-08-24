/*
There is a 0-indexed array nums of length n. Initially, all elements are uncolored (has a value of 0).

You are given a 2D integer array queries where queries[i] = [indexi, colori].

For each query, you color the index indexi with the color colori in the array nums.

Return an array answer of the same length as queries where answer[i] is the number of adjacent elements with the same color after the ith query.

More formally, answer[i] is the number of indices j, such that 0 <= j < n - 1 and nums[j] == nums[j + 1] and nums[j] != 0 after the ith query.

*/

class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] colors = new int[n];
        int[] ans = new int[queries.length];
        int prev = 0;
        for(int i = 0 ; i < queries.length; ++i) { 
            int idx = queries[i][0];
            int color = queries[i][1];
            if(colors[idx] != color) {                
                if(idx - 1 >= 0 && colors[idx - 1] != 0 && colors[idx - 1] == color) ++prev;
                if(idx + 1 < n && colors[idx + 1] != 0 && colors[idx + 1] == color) ++prev;
                if(idx - 1 >= 0 && colors[idx - 1] !=0 && colors[idx - 1] == colors[idx]) --prev;
                if(idx + 1 < n && colors[idx + 1] != 0 && colors[idx + 1] == colors[idx]) --prev;
            }
            ans[i] = prev;  
            colors[idx] = color;           
        }
        return ans;
    }
}
