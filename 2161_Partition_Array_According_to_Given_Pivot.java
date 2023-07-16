/*

You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:

Every element less than pivot appears before every element greater than pivot.
Every element equal to pivot appears in between the elements less than and greater than pivot.
The relative order of the elements less than pivot and the elements greater than pivot is maintained.
More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. For elements less than pivot, if i < j and nums[i] < pivot and nums[j] < pivot, then pi < pj. Similarly for elements greater than pivot, if i < j and nums[i] > pivot and nums[j] > pivot, then pi < pj.
Return nums after the rearrangement.
 */

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int idxSmaler = 0;
        int idxLarger = nums.length - 1;
        int[] ans = new int[nums.length];

        for(int i = 0, j = nums.length -1; i < nums.length; ++i, --j) {
          if(nums[i] < pivot) {
            ans[idxSmaler] = nums[i];
            ++idxSmaler;            
          }
          if(nums[j] > pivot) {
            ans[idxLarger] = nums[j];
            --idxLarger;
          }
        }

        while(idxSmaler <= idxLarger){
          ans[idxSmaler] = pivot;
          ++idxSmaler;
        }

        return ans;
    }
}
