class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        maxProfit = 0
        currentMinPrice = prices[0]
        for price in prices:
            currentMinPrice = min(currentMinPrice, price)
            maxProfit = max(maxProfit, price - currentMinPrice)
       
        return maxProfit
