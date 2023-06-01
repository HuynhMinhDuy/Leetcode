/*
https://leetcode.com/problems/number-of-provinces/description
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

*/

class Solution {

    private int numberPrivinces;
    private int[] graph;
    private int[] rank;

    public int find(int city) {
        if(city != graph[city]) {
            graph[city] = find(graph[city]);
        }
        return graph[city];
    }

    public void union(int cityOne, int cityTwo) {
        int parentCityOne = find(cityOne);
        int parentCityTwo = find(cityTwo);

        if(parentCityOne != parentCityTwo) {
            if(rank[parentCityOne] >= rank[parentCityTwo]) {
                graph[parentCityTwo] = parentCityOne;
                rank[parentCityOne] += rank[parentCityTwo];
            } else {
                graph[parentCityOne] = parentCityTwo;
                rank[parentCityTwo] += rank[parentCityOne];
            }
            --numberPrivinces;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int numberCities  = isConnected.length;
        numberPrivinces = numberCities;
        graph = new int[numberCities];
        rank = new int[numberCities];

        for(int city = 0 ; city < numberCities; ++city) {
            graph[city] = city;
        }

        for(int cityOne = 0; cityOne < numberCities; ++cityOne) {
            for(int cityTwo = cityOne + 1; cityTwo < numberCities; ++cityTwo) {
                if(isConnected[cityOne][cityTwo] == 1) {
                    union(cityOne, cityTwo);
                }
            }
        }

        return numberPrivinces;
    }
}
