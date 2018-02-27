public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String p1 = extendPalindrome(s, i, i);
            String p2 = extendPalindrome(s, i, i + 1);
            if (p1.length() > longest.length()) {
                longest = p1;
            }
            if (p2.length() > longest.length()) {
                longest = p2;
            }
        }
        
        return longest;
    }
    
    private String extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return s.substring(left + 1, right);
    }
}
