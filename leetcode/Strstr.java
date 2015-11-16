public class Strstr {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        
        if (m == 0) return 0;
        
        for (int i = 0; i <= n-m; i++) {
            for (int j = 0; j < m; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
                if (j == m-1) return i;
            }
        }  
        
        return -1;
    }
    
    public String strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) return haystack; // needle=""
        
        for (int i = 0; i <= n-m; i++) {
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
                if (j == m-1) return haystack.substring(i);
            }
        }
        
        return null;
    }
}
