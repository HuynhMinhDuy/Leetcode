/*
https://leetcode.com/problems/word-break/description/
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int lenS = s.length();
        boolean []dp = new boolean[lenS + 1];
        dp[0] = true;
        for (int idxS = 0; idxS < lenS; ++idxS) {
            for(String word : wordDict) {
                if(isEqual(s, idxS, word) && dp[idxS + 1 - word.length()] == true) {
                    dp[idxS+ 1] = true;
                    break;
                }
            }
        }        
        return dp[lenS];
    }

    public boolean isEqual(String s, int idxS, String word) {
        int lastIdxWord = word.length() - 1;
        while(idxS >= 0 && lastIdxWord >= 0 && word.charAt(lastIdxWord) == s.charAt(idxS)){
            --lastIdxWord;
            --idxS;
        }       
        return lastIdxWord < 0 ? true : false;
    }
}
