
/*
You are given a string s consisting only of characters 'a' and 'b'​​​​.

You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

Return the minimum number of deletions needed to make s balanced.
 
*/
class Solution {
    public int minimumDeletions(String s) {
        int len = s.length();       
        int minDelete = 0;
        int bCount = 0;
        for(int i = 0; i < len; ++i) {
            if(s.charAt(i) == 'a') {
                minDelete = Math.min(minDelete + 1, bCount);
            } else {                
                ++bCount;
            }
        }
        return minDelete;
    }
}
