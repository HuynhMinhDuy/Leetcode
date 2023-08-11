
/*
A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.
*/

class Solution {
    public String makeFancyString(String s) {
        int count = 0;
        char prevChar = ' ';
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == prevChar) {
                ++count;
            } else {
                prevChar = c;
                count = 1;
            }

            if(count < 3) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
