public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        int div = 1; // for single digit
        while (x / div >= 10) {
            div *= 10;
        }
        
        while (x > 0) {
            int left = x % 10;
            int right = x / div;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100; // x will reduce to 0 before div
        }
        
        return true;
    }
    
    public boolean isPalindrome2(int x) { // avoid overflow
        if (x < 0) return false;
        
        long origion = x;
        long reverse = 0; 
        
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        
        return reverse == origion;
    }
}
