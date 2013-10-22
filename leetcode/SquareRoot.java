public class SquareRoot {
    public int sqrt(int x) {
        assert(x >= 0);
        if (x < 2) return x; // if x=0, mid=0;
        return bsearch(x, 1, x);
    }
    
    private int bsearch(int square, int lo, int hi) {
        int bestSoFar = -1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (mid == square / mid) { // mid*mid->overflow
                return mid;
            } else if (mid < square / mid) {
                bestSoFar = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return bestSoFar;
    }
    
    // Newton's method using relative epsilon to avoid infinite loop
    public double sqrt(double x) {
        double epsilon = 1e-15;
        double t = x;
        while (Math.abs(t*t - x) > x*epsilon) t = (x/t + t) / 2.0;
        return t;
    }
}
