/*
There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).

There are n + 1 taps located at points [0, 1, ..., n] in the garden.

Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.

Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
*/

class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] intervals = new int[n + 1];
        int ans = 0;        
        for(int i = 0; i < ranges.length; ++i) {
            int minLeft = Math.max(0, i - ranges[i]);
            int maxRight = Math.min(n, i + ranges[i]);
            intervals[minLeft] = Math.max(intervals[minLeft], maxRight);
        }
        int end = 0;
        int nextEnd = 0;      

        for(int start = 0 ; start < intervals.length; ++start){     
                  
            if(start > nextEnd) {
                return -1;
            }

            if(start > end) {                              
                ++ans;
                end = nextEnd;
            } 
            nextEnd = Math.max(nextEnd, intervals[start]);      
        }

        return ans;
    }
}
