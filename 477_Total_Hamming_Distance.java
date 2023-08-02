
/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.
 
*/

class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] onebitCount = new int[32];
        int[] zerobitCount = new int[32];
        int ans = 0;
        for(int num : nums){
            countBit(num, onebitCount, zerobitCount);
        }

        for(int i = 0; i <= 31; ++i) {
            if(onebitCount[i] < nums.length && zerobitCount[i] < nums.length) {
                ans += onebitCount[i] * zerobitCount[i];
            }
        }

        return ans;
    }

    public void countBit(int num, int[] onebitCount, int[] zerobitCount) {
        for(int i = 0; i <= 31; ++i) {
            int bit = (num >>> i) & 1;
            if(bit == 1) {
                ++onebitCount[i];
            } else {
                ++zerobitCount[i];
            }
        }
    }
}
