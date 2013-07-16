public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return -1;
        int n = word1.length();
        int m = word2.length();
        
        int[][] distances = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            distances[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            distances[0][j] = j;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int insertion = distances[i][j-1] + 1;
                int deletion = distances[i-1][j] + 1;
                int substitution = distances[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j-1)) substitution += 1;
                distances[i][j] = min(insertion, deletion, substitution);
            }
        }
        
        return distances[n][m];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
