public class Strstr {
    public String strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        if (m > n) return null;
        
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
            }
            
            if (j == m) return haystack.substring(i);
        }
        
        return null;
    }
}
