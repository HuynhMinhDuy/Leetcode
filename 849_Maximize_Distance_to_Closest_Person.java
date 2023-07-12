/*
You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to the closest person.
*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDist = Integer.MAX_VALUE;
        int firstPerson = 0;
        int lastPerson = seats.length - 1;
        int countEmptySeat = 0;

        while(firstPerson < seats.length && seats[firstPerson] == 0) {
            ++firstPerson;
        }
        while (lastPerson >= 0 && seats[lastPerson] == 0) {
            --lastPerson;
        }

        maxDist = Math.max(firstPerson, seats.length - 1 - lastPerson);

        for(int pos = firstPerson; pos <= lastPerson; ++pos){
            if(seats[pos] == 0) {
                ++countEmptySeat;
            } else {
                countEmptySeat = 0;
            }

            if(countEmptySeat % 2 != 0) {
                maxDist = Math.max(maxDist, (countEmptySeat + 1) / 2);
            } else {
                maxDist = Math.max(maxDist, countEmptySeat / 2);
            }
        }

        return maxDist;
    }
}
