/*
https://leetcode.com/problems/group-anagrams/description
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs) {
            String key = getKey(str);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        for(String key : map.keySet()) {            
            ans.add(map.get(key));
        }

        return ans;
    }

    public String getKey(String str){
        int[] freqs = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()) {
            ++freqs[c - 'a'];
        }

        for(int freq : freqs){
            sb.append(freq);
            sb.append("_");
        }

        return sb.toString();
    }
}
