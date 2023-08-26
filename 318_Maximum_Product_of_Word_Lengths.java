/*
Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.
*/
class Solution {

    private int[] map;

    public boolean isNotCommon(int i, int j) {
        return (map[i] & map[j]) == 0 ? true : false;
    }

    public int maxProduct(String[] words) {
        int maxProduct = 0;
        map = new int[words.length];

        for(int i = 0 ; i < words.length; ++i) {
            int mask = 0;
            for(char c : words[i].toCharArray()) {
                int idx = c - 'a';
                mask |= 1 << idx;
            }
            map[i] = mask;
        }
       
       for(int i = 0; i < words.length; ++i) {
           for(int j = i + 1; j < words.length; ++j) {
               if(isNotCommon(i, j)) {
                   maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
               }
           }
       }

        return maxProduct;
    }
}
