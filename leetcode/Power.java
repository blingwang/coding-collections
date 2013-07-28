public class Power {
    /* Solution 1 using recursion*/
    public double pow(double x, int n) {
        if (n == 0) return 1.0;
        
        double half = pow(x, n/2);
        if (n % 2 == 0) return half * half;
        else if (n > 0) return half * half * x;
        else            return half * half * (1/x);
    }
    
    /* Solution 2 using iteration*/
    public double pow2(double x, int n) {
        double result = 1.0;
        while (n != 0) {
            if ((n&1) == 1) {
                if (n > 0) result *= x;
                else       result *= 1/x;
            } 
            // x^(2k) = (x^2)^k;
            x *= x;
            n /= 2;
        }
        
        return result;
    }
    
     /* Solution 3 using iteration*/
    public double pow3(double x, int n) {  
        double result = 1;  
        for (int m = Math.abs(n); m > 0; x *= x, m >>= 1) {  
             if ((m & 1) == 1) result *= x;  
        }  
        
        return (n >= 0) ? result : 1.0 / (result);  
    }  
}
