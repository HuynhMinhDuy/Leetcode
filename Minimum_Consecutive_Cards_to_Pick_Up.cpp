/*
  https://leetcode.com/problems/minimum-consecutive-cards-to-pick-up/description/
  You are given an integer array cards where cards[i] represents the value of the ith card. A pair of cards are matching if the cards have the same value.

Return the minimum number of consecutive cards you have to pick up to have a pair of matching cards among the picked cards. If it is impossible to have matching cards, return -1
*/
class Solution {
public:
    int minimumCardPickup(vector<int>& cards) {
        int ans = cards.size()  + 1 ;
        unordered_map<int, int> m;
        for(int i = 0; i < cards.size(); ++i) {
            if(m.find(cards[i]) != m.end()) {
                ans = min(ans, i - m[cards[i]] + 1);
            }
            m[cards[i]] = i;
        }

        return ans == cards.size()  + 1 ?  -1 : ans ;
    }
};
