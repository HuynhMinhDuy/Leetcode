
/*
Given two integer arrays pushed and popped each with distinct values, 
return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise. 
*/
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st  = new Stack<>();
        int idxPush = 0;
        int idxPop = 0;
        while(idxPush < pushed.length) {                     
            st.push(pushed[idxPush]);
            ++idxPush;        
            while(!st.isEmpty() && st.peek() == popped[idxPop]){               
                st.pop();
                ++idxPop;                                            
            }        
        }      

        return idxPop == popped.length;
    }
}
