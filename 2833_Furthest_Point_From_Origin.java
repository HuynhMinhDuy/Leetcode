/*
You are given a string moves of length n consisting only of characters 'L', 'R', and '_'. The string represents your movement on a number line starting from the origin 0.

In the ith move, you can choose one of the following directions:

move to the left if moves[i] = 'L' or moves[i] = '_'
move to the right if moves[i] = 'R' or moves[i] = '_'
Return the distance from the origin of the furthest point you can get to after n moves.
*/
class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int moveRight = 0;
        int moveLeft = 0;
        int space = 0;
        for(char c : moves.toCharArray()) {
            if(c == 'L') {
                ++moveLeft;
            } else if( c == 'R') {
                ++moveRight;
            } else {
                ++space;
            }
        }
        return space + Math.max(moveRight, moveLeft) - Math.min(moveRight, moveLeft);
    }
}
