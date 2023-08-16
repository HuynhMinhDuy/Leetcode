
/*
You are given two 0-indexed integer arrays nums1 and nums2 of length n.

Let's define another 0-indexed integer array, nums3, of length n. For each index i in the range [0, n - 1], you can assign either nums1[i] or nums2[i] to nums3[i].

Your task is to maximize the length of the longest non-decreasing subarray in nums3 by choosing its values optimally.

Return an integer representing the length of the longest non-decreasing subarray in nums3.

Note: A subarray is a contiguous non-empty sequence of elements within an array.
*/

class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        
        int ans = 1;
        int prev0 = 1;
        int prev1 = 1;

        for(int i = 1; i < nums1.length ; ++i) {
            
            int dp0 = 1;
            int dp1 = 1;

            if(nums1[i] >= nums1[i - 1]) {
                dp0 = Math.max(dp0, prev0 + 1);
            }

            if(nums1[i] >= nums2[i - 1]) {
                dp0 = Math.max(dp0, prev1 + 1);            
            }

            if(nums2[i] >= nums2[i - 1]) {
                dp1  = Math.max(dp1, prev1 + 1);
            }

            if(nums2[i] >= nums1[i - 1]) {
                dp1 = Math.max(dp1, prev0+ 1);            
            }
            ans = Math.max(ans, Math.max(dp0, dp1));

            prev0 = dp0;
            prev1 = dp1;            
        }

        return ans;
    }
}
