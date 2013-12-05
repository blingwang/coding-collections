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
        int maxLength = 0;
        int start = 0;
        int[] lastIndice = new int[26];
        
        s = s.toLowerCase();
        Arrays.fill(lastIndice, -1);
        
        for (int i = 0; i < s.length(); i++) {
            char curLetter = s.charAt(i);
            
            if (lastIndice[curLetter-'a'] >= start) {
                start = lastIndice[curLetter-'a'] + 1;
            }
            
            int curLength = i - start + 1;
            maxLength = Math.max(maxLength, curLength);
            lastIndice[curLetter-'a'] = i;
        }
        
        return maxLength;
    }
}
