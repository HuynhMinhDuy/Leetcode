
/*

Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.


*/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int totalLen = 0;
        int countWord = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i <= words.length; ++i) {

            if(i == words.length) {
                int lenLastLine = sb.length();
                for(int j= lenLastLine; j < maxWidth; ++j) {
                    sb.append(" ");
                }
                ans.add(sb.toString());
            } else {
                String word = words[i];
                ++countWord;
                int len = word.length();
                int space = Math.max(0, countWord - 1);
                if(totalLen + len + space <= maxWidth) {                    
                    totalLen += len;
                } else {
                    String s = processWord(sb.toString(), maxWidth);
                    ans.add(s);
                    countWord = 1;
                    sb = new StringBuilder(); 
                    totalLen = len;
                }

                if(sb.length() > 0) sb.append(" ");
                sb.append(word);                
            }            
        }

        return ans;
    }

    public String processWord(String word, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int space = 0;
        int firstSpace = -1;
        int remainSpace = maxWidth - word.length();
        if(remainSpace == 0) return word;

        for(int i = 0; i < word.length(); ++i) {
            if(word.charAt(i) == ' '){
                if(firstSpace == -1) {
                    firstSpace = i;
                }
                ++space;
            }
        }

        if(space == 0) {
            int k = 0;
            while (k < maxWidth) {
                if(k < word.length()) {
                    sb.append(word.charAt(k));
                } else {
                    sb.append(" ");                    
                }
                ++k;
            }            
            return sb.toString();
        }        

        int totalSpace = 1 + remainSpace / space;       
        int leftSpace = remainSpace % space;       

        for(int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if(c == ' ') {               
                for(int k = 0; k < totalSpace; ++k) {
                    sb.append(" ");
                }
                if(leftSpace > 0) {
                    sb.append(" ");
                    --leftSpace;
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
