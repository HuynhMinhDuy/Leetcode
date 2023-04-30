/*
  https://leetcode.com/problems/climbing-stairs/
  You are climbing a staircase. It takes n steps to reach the top.

  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
*/
class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        a = 1
        b = 1
        c = 0
        for step in range(1,n):
            c = a + b
            a = b
            b = c
        
        return b
            
