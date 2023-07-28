class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int ans = maxDiff(nums, 0, nums.length - 1);
        
        return ans >= 0 ? true : false;
    }

    public int maxDiff(int []nums, int left , int right) {
        if(left == right) {
            return nums[left];
        }
        int maxLeft = nums[left] - maxDiff(nums, left + 1, right);
        int maxRight = nums[right] - maxDiff(nums, left, right -1);
        return Math.max(maxLeft, maxRight);
    }
}
