import java.util.*;

public class LongestNonRepeatedSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0; // non-repeated substring start
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur) && map.get(cur) >= start) {
                int last = map.get(cur);
                maxLength = Math.max(maxLength, i - start);
                start = last + 1;
            }
            
            map.put(cur, i);
        }
        
        maxLength = Math.max(maxLength, s.length() - start);
        return maxLength;
    }
    
    public int lengthOfLongestSubstring2(String s) {
        s.toLowerCase();
        int max = 0;
        int start = 0;
        
        int[] charIndice = new int[26];
        for (int i = 0; i < charIndice.length; i++) {
            charIndice[i] = -1;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int last = charIndice[cur-'a'];
            if (last >= 0 && last >= start) {
                int length = i - start;
                if (length > max) max = length; 
                start = last + 1;
            }
            
            charIndice[cur-'a'] = i;
        }
        
        // process last substring
        if (s.length() - start > max) max = s.length() - start;
        
        return max;
    }
}
