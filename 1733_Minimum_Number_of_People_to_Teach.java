/*
On a social network consisting of m users and some friendships between users, two users can communicate with each other if they know a common language.

You are given an integer n, an array languages, and an array friendships where:

There are n languages numbered 1 through n,
languages[i] is the set of languages the i​​​​​​th​​​​ user knows, and
friendships[i] = [u​​​​​​i​​​, v​​​​​​i] denotes a friendship between the users u​​​​​​​​​​​i​​​​​ and vi.
You can choose one language and teach it to some users so that all friends can communicate with each other. Return the minimum number of users you need to teach.

Note that friendships are not transitive, meaning if x is a friend of y and y is a friend of z, this doesn't guarantee that x is a friend of z.

*/

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> canNotSpeak = new HashSet<>();
        int numberPeopleNeedTeach = 0;
        int maxFreqLanguage = 0;
        int[] freqLanguage = new int[n + 1];

        for(int[] friendship : friendships) {
            if(!canSpeak(friendship[0] - 1, friendship[1] - 1, languages)) {
                canNotSpeak.add(friendship[0] - 1);
                canNotSpeak.add(friendship[1] - 1);
            }
        }
        numberPeopleNeedTeach = canNotSpeak.size();
        for(int person : canNotSpeak) {
            for(int l : languages[person]) {
                ++freqLanguage[l];
                maxFreqLanguage = Math.max(maxFreqLanguage, freqLanguage[l]);
            }
        }

        return numberPeopleNeedTeach - maxFreqLanguage;
    }

    public boolean canSpeak(int p1, int p2, int[][] languages) {
        Set<Integer> personOneLanguages = new HashSet<>();
        int[] personOneCanSpeaks = languages[p1];
        for(int l : personOneCanSpeaks) {
            personOneLanguages.add(l);
        }
        for(int personTwoSpeak : languages[p2]) {
            if(personOneLanguages.contains(personTwoSpeak) == true) {
                return true;
            }
        }
        return false;
    }
}
