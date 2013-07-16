public class SquareRoot {
    public int sqrt(int x) {
        assert(x >= 0);
        if (x < 2) return x;
        
        int left = 1, right = x;
        
        // find last two that left <= target <= right since no duplicates
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (x / mid == mid) return mid;
            if (x / mid < mid) right = mid;
            else left = mid;
        }
        
        return left;
    }
    
    // Newton's method using relative epsilon to avoid infinite loop
    public double sqrt(double x) {
        double epsilon = 1e-15;
        double t = x;
        while (Math.abs(t*t - x) > x*epsilon) t = (x/t + t) / 2.0;
        return t;
    }
}
