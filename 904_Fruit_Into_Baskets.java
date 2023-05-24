/*
https://leetcode.com/problems/fruit-into-baskets/description/
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

*/

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> m = new HashMap<>();
        int maxFruits = 0;
        for(int end = 0, start = 0; end < fruits.length; ++end) {
            m.put(fruits[end], m.getOrDefault(fruits[end], 0) + 1);
            if(m.size() <= 2) {
                maxFruits = Math.max(maxFruits, end - start + 1);
            } else {
                int startFruit = m.get(fruits[start]);
                if(startFruit == 1) {
                    m.remove(fruits[start]);
                }  else {
                    m.put(fruits[start],startFruit -1);
                }
                ++start;
            }
        }
        return maxFruits;
    }
}
