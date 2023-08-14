/*
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = partition(nums, left, right);
            if(mid == k - 1) {
                return nums[mid];
            } else if( mid < k - 1) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }

        return -1;
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int j = start;
        for(int i = start; i < end; ++i) {
            if(nums[i] >= pivot) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                ++j;
            }
        }
        nums[end] = nums[j];
        nums[j]  = pivot;
        return j;
    }
}
