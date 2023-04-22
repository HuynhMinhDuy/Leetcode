/*
  https://leetcode.com/problems/container-with-most-water/description/
  
  You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

  Find two lines that together with the x-axis form a container, such that the container contains the most water.

  Return the maximum amount of water a container can store.

  Notice that you may not slant the container.
*/

class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0; 
        int r = height.length - 1;
        int minHeight = 0;
        int len = 0;
        while (l < r) {    
            len = r - l;        
            if(height[l] > height[r]) {
                minHeight = height[r];
                --r;
            } else {
                minHeight = height[l];
                ++l;
            }
            ans = Math.max(ans, minHeight * len);
        }

        return ans;
    }
}
