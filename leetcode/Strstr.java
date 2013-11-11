public class Strstr {
    public String strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
            }
            
            // must check after loop for ("", "")
            if (j == m) return haystack.substring(i);
        }
        
        return null;
    }
}
