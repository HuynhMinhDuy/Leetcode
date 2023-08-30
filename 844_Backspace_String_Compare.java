

/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 
*/
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int idxS = s.length() - 1;
        int idxT = t.length() - 1;
        int countS = 0;
        int countT = 0;

        while(idxS >= 0 || idxT >= 0) {

            while(idxS >= 0 && (s.charAt(idxS) == '#' || countS > 0)) {
                if(s.charAt(idxS) == '#') {
                    ++countS;
                } else {
                    --countS;
                }
                --idxS;
            }

            while(idxT >= 0 && (t.charAt(idxT) == '#' || countT > 0)) {
                if(t.charAt(idxT) == '#') {
                    ++countT;
                } else {
                    --countT;
                }
                --idxT;
            }

            if(idxT >= 0 && idxS >= 0) {
                if(s.charAt(idxS) != t.charAt(idxT)) { 
                    return false;
                }
                --idxT;
                --idxS;
            } else if(idxT == -1 && idxS == -1) {               
                return true;
            } else {
                return false;
            }

        }

        return true;
    }
}
