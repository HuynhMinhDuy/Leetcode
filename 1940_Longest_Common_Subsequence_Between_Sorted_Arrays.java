/*
Given an array of integer arrays arrays where each arrays[i] is sorted in strictly increasing order, return an integer array representing the longest common subsequence between all the arrays.

A subsequence is a sequence that can be derived from another sequence by deleting some elements (possibly none) without changing the order of the remaining elements.
*/

class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        List<Integer> ans  = new ArrayList<>();
        int numberArray = arrays.length;
        int[] idxs = new int[numberArray];
        int currentMax = Integer.MIN_VALUE;
        int nextMax = Integer.MIN_VALUE;
        boolean next = true;

        for(int[] arr : arrays) {
            nextMax = arr[0];
        }

        while (next == true) {

            currentMax = nextMax;
            int currentMath  = 0;

            for(int row = 0; row < numberArray ; ++row) {

                int idx = idxs[row];
                int actualIdx = arrays[row].length;

                if(idx == actualIdx) {
                   next = false;
                } else if(idx < actualIdx) {
                    nextMax = Math.max(nextMax, arrays[row][idx]);
                    if(arrays[row][idx] < currentMax) {
                        ++idxs[row];
                    } else if (arrays[row][idx] == currentMax) {
                        ++currentMath;                        
                    }
                }
            }

            if(currentMath == numberArray) {                
                ans.add(arrays[0][idxs[0]]); 
                for(int row = 0; row < numberArray; ++row) {
                    ++idxs[row];
                    if(idxs[row] < arrays[row].length) {
                        nextMax = Math.max(nextMax, arrays[row][idxs[row]]);
                    }             
                }
            }
        }
        return ans;
    }
}
