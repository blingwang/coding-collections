public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int[] charCountS = new int[26];
        int[] charCountT = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCountS[c-'a']++;    
        }
        
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            charCountT[c-'a']++;    
        }
        
        for (int i = 0; i < 26; i++) {
            if (charCountS[i] != charCountT[i]) {
                return false;
            }
        }
        
        return true;
    }
}
