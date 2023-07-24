
/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
*/

class Solution {

   public double myPow(double x, int n) {

       long N = n;
       if (N < 0) {
           return 1 / pow(x, -N);
       }  
       return pow(x, N);
   } 

    public double pow(double x, long n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        double y = pow(x, n / 2);
        if(n % 2 == 0) {            
            return y * y;
        } 

        return y * y * x;
    }
}
