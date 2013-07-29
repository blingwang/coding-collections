public class ValidatePalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        s = s.toLowerCase(); // reassign: Strings are immutable
        
        int start = 0;
        int end = s.length() - 1;
        while (true) {
            while (start < s.length() && !isWordChar(s.charAt(start))) start++;
            while (end >= 0 && !isWordChar(s.charAt(end))) end--;
            if (start >= end) break;
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        
        return true;
    }

    private boolean isWordChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}
