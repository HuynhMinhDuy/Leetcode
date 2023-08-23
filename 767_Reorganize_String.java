/*
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.
*/

class Solution {
    public String reorganizeString(String s) {
        int[][] freq = new int[26][2];
        char[] ans = new char[s.length()];        

        for(char c : s.toCharArray()) {
            ++freq[c - 'a'][1];
            freq[c - 'a'][0] = c - 'a';
        }
       
        Arrays.sort(freq, (a, b) -> b[1] - a[1]);

        int i = 0;
        int j = 0;

        while(i < ans.length) {
           
           ans[i] = (char)(freq[j][0] + 'a');
           --freq[j][1];
           if(freq[j][1] == 0) {
               ++j;
           }

           if(i > 0 && ans[i] == ans[i - 1]) {
               return "";
           }
           i += 2; 
           if(i > ans.length - 1 && i % 2 == 0) {
               i = 1;
           }          
        }               
      
        return new String(ans);
    }
}
