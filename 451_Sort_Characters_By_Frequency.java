/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.
*/  
class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        int[][] freqs = new int[256][2];
        for(char c : s.toCharArray()) {
            freqs[c][0] = c;
            ++freqs[c][1];
        }

        Arrays.sort(freqs, (a, b) -> b[1] - a[1]);

        for(int[] freq : freqs) {
            char c = (char)freq[0];
            int freqC = freq[1];
            while(freqC > 0) {
                sb.append(c);
                --freqC;
            }
        }

        return sb.toString();
    }
}
