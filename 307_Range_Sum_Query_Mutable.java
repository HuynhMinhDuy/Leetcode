/*
Given an integer array nums, handle multiple queries of the following types:

Update the value of an element in nums.
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
void update(int index, int val) Updates the value of nums[index] to be val.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 
*/

class NumArray {

    private int[] nums;
    private int[] BIT;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        BIT = new int[nums.length + 1];
        createBIT(nums);
    }
    
    public void createBIT(int[] nums) {
        for(int idx = 0; idx < nums.length; ++idx) {
            update(idx, nums[idx]);
        }
    }

    public void update(int index, int val) {
        int diff = val - this.nums[index];
        this.nums[index] = val;
        int idx = index + 1;
        while(idx < BIT.length) {
            BIT[idx] += diff;
            idx += idx & (-idx);
        }
    }
    
    public int sumRange(int left, int right) {
        int sumLeft = 0;
        int sumRight = 0;
        int l = left;
        int r = right + 1;

        while(l > 0) {
            sumLeft += BIT[l];
            l -= l & (-l);
        }
        while(r > 0) {
            sumRight += BIT[r];
            r -= r & (-r);
        }
        return sumRight - sumLeft;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
