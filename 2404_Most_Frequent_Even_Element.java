
/*
Given an integer array nums, return the most frequent even element.

If there is a tie, return the smallest one. If there is no such element, return -1.
*/
class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int ans = -1;
        int currentMax = 0;
        
        for(int num : nums) {
          if(num % 2 == 0) {
            m.put(num, m.getOrDefault(num, 0) + 1);
            int freqValue = m.get(num);
            if(freqValue > currentMax || (freqValue == currentMax && ans > num)) {
              ans = num;
              currentMax = freqValue;
            }
          }
        }
        return ans;
    }
}
