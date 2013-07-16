public class DivideIntegers {
    public int divide(int dividend, int divisor) {
        assert(divisor != 0);
        if (dividend == 0 || divisor == 1) return dividend;
        if (dividend == -1) return -dividend;
        
        long dvd = (long)Math.abs((double)dividend);
        long dvs = (long)Math.abs((double)divisor);
        int ret = 0;
        
        while (dvd >= dvs) {
            long temp = dvs;
            for (int i = 0; dvd >= temp; i++, temp <<= 1) {
                dvd -= temp;
                ret += 1 << i;
            }
        }
        
        return ((dividend ^ divisor) >> 31) == 0 ? ret : -ret;
    }
}
