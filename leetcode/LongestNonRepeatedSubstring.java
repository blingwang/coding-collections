import java.util.*;

public class LongestNonRepeatedSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                j = Math.max(j, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - j + 1);
        }
        return max;
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
