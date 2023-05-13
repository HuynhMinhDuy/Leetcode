/*
  https://leetcode.com/problems/valid-palindrome/description
  A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

  Given a string s, return true if it is a palindrome, or false otherwise.
*/

class Solution {
public:
    bool isPalindrome(string s) {
        int left  = 0;
        int right = s.length() - 1;

        while (left < right) {
            while(left < right && isalnum(s[left]) == 0) {                
                ++left;
            }

            while(left < right && isalnum(s[right]) == 0) {
                --right;
            }

            if(left < right) {
                char leftCharacter = s[left]; 
                char rightCharacter = s[right];
                if(leftCharacter <= 90) {
                     leftCharacter +=32;   
                }
                if(rightCharacter <= 90) {
                     rightCharacter +=32;   
                }

                if(leftCharacter != rightCharacter) {
                    return false;
                }
            }
            ++left;
            --right;
        }

        return true;
    }
};
