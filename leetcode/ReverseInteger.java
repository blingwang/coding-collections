public class ReverseInteger {
    public int reverse(int x) {
        int sign = 1;
        if (x < 0) {
            if (x == Integer.MIN_VALUE) return x;
            sign = -1;
            x = -x;
        }
        
        long result = 0;
        
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        
        if (result > Integer.MAX_VALUE) {
            return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        
        return (int)result * sign;
    }
    
    public int reverse2(int x) {// let java do overflow check
        long result = 0;
        
        while(x != 0) { // java module returns negative
            result = result * 10 + x % 10;
            x /= 10;
        }
        
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        
        return (int)result;
    }
}
