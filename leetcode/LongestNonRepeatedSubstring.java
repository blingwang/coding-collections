public class LongestNonRepeatedSubstring {
    public int lengthOfLongestSubstring(String s) {
        s.toLowerCase();
        int max = 0;
        int startIndex = 0;
        
        int[] charIndice = new int[26];
        for (int i = 0; i < charIndice.length; i++) {
            charIndice[i] = -1;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (charIndice[s.charAt(i)-'a'] == -1) {
               charIndice[s.charAt(i)-'a'] = i; 
            } else {
                int length = i - startIndex;
                if (length > max) max = length; 
                startIndex = charIndice[s.charAt(i)-'a'] + 1;
                
                for (int j = 0; j < charIndice.length; j++) {
                    if (charIndice[j] < charIndice[s.charAt(i)-'a']) {
                        charIndice[j] = -1;
                    }
                } 
                
                charIndice[s.charAt(i)-'a'] = i;           
            }
        }
        
        // process last substring
        if (s.length() - startIndex > max) max = s.length() - startIndex;
        
        return max;
    }
}
