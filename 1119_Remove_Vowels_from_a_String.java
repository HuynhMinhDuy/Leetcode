
/*
Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
*/

class Solution {
    public String removeVowels(String s) {
        boolean[] chars = new boolean[26];
        chars['a' - 'a']  = true;
        chars['e' - 'a'] = true;
        chars['i' - 'a'] = true;
        chars['o' - 'a'] = true;
        chars['u' - 'a'] = true;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(chars[c - 'a'] == false) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
