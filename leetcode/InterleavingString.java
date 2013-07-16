public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != m + n) return false;
        
        // DP solution similar to Robot path problem
        boolean[][] matched = new boolean[m+1][n+1]; // i,j: # of matched chars
        matched[0][0] = true;
        
        for (int i = 1; i <= m; i++) {
            matched[i][0] = matched[i-1][0] && isSameChar(s1,s3,i-1,i-1);
        }
        
        for (int j = 1; j <= n; j++) {
            matched[0][j] = matched[0][j-1] && isSameChar(s2,s3,j-1,j-1);
        }
        
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <= n; j++) {
                matched[i][j] = (matched[i-1][j] && isSameChar(s1,s3,i-1,i+j-1)) ||
                                (matched[i][j-1] && isSameChar(s2,s3,j-1,i+j-1));
            }
        }
        
        return matched[m][n];
    }

    private boolean isSameChar(String s1, String s2, int i, int j) {
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        return c1 == c2;
    }
}
