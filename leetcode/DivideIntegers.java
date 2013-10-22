public class DivideIntegers {
    public int divide(int dividend, int divisor) {
        assert(divisor != 0);
        if (dividend == 0 || divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        
        long divd = (long)Math.abs((double)dividend);
        long divs = (long)Math.abs((double)divisor);
        int result = 0;
        
        while (divd >= divs) {
            long curDivisor = divs;
            for (int i = 0; curDivisor <= divd; i++, curDivisor <<= 1) {
                divd -= curDivisor;
                result += 1 << i;
            }
        }
        
        return ((dividend ^ divisor) >> 31) == 0 ? result : -result;
    }
}
