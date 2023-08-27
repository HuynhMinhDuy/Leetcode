
/*
You are given an array of positive integers beans, where each integer represents the number of magic beans found in a particular magic bag.

Remove any number of beans (possibly none) from each bag such that the number of beans in each remaining non-empty bag (still containing at least one bean) is equal. Once a bean has been removed from a bag, you are not allowed to return it to any of the bags.

Return the minimum number of magic beans that you have to remove.

 
*/

class Solution {
    public long minimumRemoval(int[] beans) {
        long prefixSumLeft = 0;
        long prefixSumRight = 0;         
        long ans = Long.MAX_VALUE;;
        Arrays.sort(beans);        

        for(int i = 0; i < beans.length; ++i) {
          prefixSumRight += beans[i];
        }

        for(int i = 0 ; i < beans.length; ++i) {
          long bean = beans[i];    
          prefixSumRight -= beans[i];
          long rightSum = prefixSumRight - (beans.length - 1 - i) * bean;          
          ans = Math.min(ans, prefixSumLeft + rightSum);
          prefixSumLeft += beans[i];
        }

        return ans;
    }
}
