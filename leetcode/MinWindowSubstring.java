class Solution {
//     1. Use two pointers: start and end to represent a window.
//     2. Move end to find a valid window.
//     3. When a valid window is found, move start to find a smaller window.
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        int[] targetCount = new int[256];
        for (int i = 0; i < t.length(); i++) {
            targetCount[t.charAt(i)]++;
        }
        
        int minStart = -1;
        int minLength = Integer.MAX_VALUE;
        int numCharsFound = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            if (targetCount[s.charAt(end)] > 0) numCharsFound++;
            targetCount[s.charAt(end)]--;
            
            while (numCharsFound == t.length()) {
                if (end - start + 1 < minLength) {
                    minStart = start;
                    minLength = end - start + 1;
                }
                
                if (targetCount[s.charAt(start)] == 0) numCharsFound--;
                targetCount[s.charAt(start)]++;
                start++;
            }
        }
        
        return minStart == -1 ? "" : s.substring(minStart, minStart + minLength);
    }
    
    public String minWindowUsingMap(String s, String t) {
        if (s.length() < t.length()) return "";
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int minStart = -1;
        int minLength = Integer.MAX_VALUE;
        int numCharsFound = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char charEnd = s.charAt(end);
            if (map.containsKey(charEnd)) {
                if (map.get(charEnd) > 0) numCharsFound++;
                map.put(charEnd, map.get(charEnd) - 1);
            }
            
            while (numCharsFound == t.length()) {
                if (end - start + 1 < minLength) {
                    minStart = start;
                    minLength = end - start + 1;
                }
                
                char charStart = s.charAt(start++);
                if (map.containsKey(charStart)) {
                    if (map.get(charStart) == 0) numCharsFound--;
                    map.put(charStart, map.get(charStart) + 1);
                } 
            }
        }
        
        return minStart == -1 ? "" : s.substring(minStart, minStart + minLength);
    }
}
