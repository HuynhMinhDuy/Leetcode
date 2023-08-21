
/*
Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
*/
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int []lps = new int[n];
        int i = 0;
        int j = 1;
        while(j < n) {
            if(s.charAt(i) == s.charAt(j)) {
                ++i;
                lps[j] = i;
                ++j;
            } else {
                if(i > 0) {
                    i = lps[i-1];
                } else {
                    ++j;
                }
            }
        }
        
        return lps[n-1] != 0 && (lps[n-1] % (n - lps[n-1])) == 0;
    }
}
