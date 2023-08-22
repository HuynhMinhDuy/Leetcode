/*
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
*/
class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0) {
            --columnNumber;
            char lastChar = (char)((columnNumber % 26) + 'A');
            sb.append(lastChar);
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
