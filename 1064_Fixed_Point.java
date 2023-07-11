/*
Given an array of distinct integers arr, where arr is sorted in ascending order, return the smallest index i that satisfies arr[i] == i. 
If there is no such index, return -1.
*/

class Solution {
    public int fixedPoint(int[] arr) {
        int l  = 0; 
        int r = arr.length - 1;
        int ans = -1;
        while( l <= r) {
            int mid = l +( r - l) / 2;
            if(mid <= arr[mid]) {
                if(mid == arr[mid]) {
                    ans = mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
