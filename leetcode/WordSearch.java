import java.util.*;

public class WordSearch {
    private char[][] board;
    private int m, n;
    private String word;
    private boolean[][] marked;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        this.word = word;
        marked = new boolean[m][n];
        
        if (m * n < word.length()) return false;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(i, j, 0)) return true;
            }
        }
        
        return false;
    }
    
    private boolean searchWord(int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        if (marked[i][j]) return false;
        if (board[i][j] != word.charAt(index)) return false;
        
        marked[i][j] = true;
        
        if (searchWord(i-1, j, index+1)) return true;
        if (searchWord(i+1, j, index+1)) return true;
        if (searchWord(i, j-1, index+1)) return true;
        if (searchWord(i, j+1, index+1)) return true;
        
        marked[i][j] = false;
        
        return false;
    }
}
