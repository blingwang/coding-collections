import java.util.*;
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (!isAnagram(s1,s2)) return false;
        
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            String part1 = s1.substring(0, i);
            String part2 = s1.substring(i);
            String nonSwap1 = s2.substring(0, i);
            String nonSwap2 = s2.substring(i);
            String swap1 = s2.substring(n-i);
            String swap2 = s2.substring(0, n-i);
            
            if (isScramble(part1, nonSwap1) && isScramble(part2, nonSwap2)) return true;
            if (isScramble(part1, swap1) && isScramble(part2, swap2)) return true;      
        }
        
        return false;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return (new String(chars1)).equals(new String(chars2));
    }

    private boolean isAnagram2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;

        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)-'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            count[c-'a']--;
            if (count[c-'a'] < 0) return false;
        }

        return true;
    }
}
