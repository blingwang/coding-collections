public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if (s.length() == 0) return "";
        
        String longest = s.substring(0, 1); // single char string
        for (int i = 0; i < s.length() - 1; i++) {
            String p1 = expandAroundCenter(s, i, i);
            if (p1.length() > longest.length()) longest = p1;
            String p2 = expandAroundCenter(s, i, i+1);
            if (p2.length() > longest.length()) longest = p2;
        }
        
        return longest;
    }

    private String expandAroundCenter(String s, int center1, int center2) {
        int left = center1, right = center2;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return s.substring(left+1, right);
    }
}
