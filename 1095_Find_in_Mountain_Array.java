/*
(This problem is an interactive problem.)

You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.

You cannot access the mountain array directly. You may only access the array using a MountainArray interface:

MountainArray.get(k) returns the element of the array at index k (0-indexed).
MountainArray.length() returns the length of the array.
Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.
*/

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray nums) {
        int l = 0 ;
        int r = nums.length() - 1;
        int peak = 0;

        // Find peak element
        while (l < r) {
            int mid = l + (r - l) / 2;
            int midValue = nums.get(mid);
            int nextValue = nums.get(mid + 1);
            if(midValue < nextValue) {
                l = mid + 1;
            } else {
                peak = mid;
                r = mid;
            }
        }

        // Binary search left
        l = 0; 
        r = peak;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midValue = nums.get(mid);
            if(midValue == target) {
                return mid;
            } else if(midValue < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // Binary search right
        l = peak + 1;
        r = nums.length() - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            int midValue = nums.get(mid);
            if(midValue == target) {
                return mid;
            } else if(midValue < target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return -1;
    }
}
