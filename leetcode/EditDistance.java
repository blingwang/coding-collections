public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] distTable = new int[m+1][n+1];
        
        for (int i = 1; i <= m; i++) {
            distTable[i][0] = i;
        }
        
        for (int j = 1; j <= n; j++) {
            distTable[0][j] = j;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int byInsert = distTable[i][j-1] + 1;
                int byDelete = distTable[i-1][j] + 1;
                int bySubstitute = distTable[i-1][j-1];
                
                if (word1.charAt(i-1) != word2.charAt(j-1)) bySubstitute++;
                
                distTable[i][j] = min(byInsert, byDelete, bySubstitute);
            }
        }
        
        return distTable[m][n];
    }
    
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
