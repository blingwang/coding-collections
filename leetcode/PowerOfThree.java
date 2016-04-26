public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;    
    }
    
    // base conversion
    public boolean isPowerOfThree2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}
