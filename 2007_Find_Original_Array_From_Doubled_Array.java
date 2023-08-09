
/*
An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.

Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.
*/

class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length % 2 != 0) return new int[0];
        int[] ans = new int[changed.length / 2];
        Arrays.sort(changed);
        Map<Integer, Integer> m = new HashMap<>();
        for(int num : changed) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
      
        for(int i = 0, j = 0; i < changed.length; ++i) {
            int freqNum = m.get(changed[i]);
            if(freqNum != 0){
                if(!m.containsKey(2 * changed[i]) || m.get(2 * changed[i]) == 0 || (changed[i] == 0 && freqNum % 2 != 0)) {
                    return new int[0];
                } else {
                    m.put(changed[i], freqNum - 1);
                    m.put(2 * changed[i], m.get(2 * changed[i]) - 1);
                    ans[j] = changed[i];
                    ++j;
                }
            }
        }

        return ans;
    }
}
