import java.util.*;

public class WordSearch {
    char[][] board;
    int m, n;
    String word;
    HashSet<Integer> marked;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        this.board = board;
        this.word = word;
        marked = new HashSet<Integer>();
        
        if(m * n < word.length()) return false;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) return true;
            }
        }
        
        return false;
    }

    private boolean dfs(int i, int j, int count) {
        if ( count == word.length()) return true;
        if ( i < 0 || i >= m || j < 0 || j >= n) return false;
        if (marked.contains(i*n+j)) return false;
        if ( board[i][j] != word.charAt(count)) return false;
        
        marked.add(i*n+j);
        
        if (dfs(i-1, j, count+1)) return true;
        if (dfs(i+1, j, count+1)) return true;
        if (dfs(i, j-1, count+1)) return true;
        if (dfs(i, j+1, count+1)) return true;
        
        marked.remove(i*n+j);
        
        return false;
    }
}
