import java.util.*;

public class SurroundedRegions {
    private char[][] board;
    private int m;
    private int n;
    
    public void solve(char[][] board) {
        if (board.length == 0) return;
        this.board = board;
        m = board.length;
        n = board[0].length;
        
        //markOpenRegions();
        markOpenRegionsBFS();
        setSurroundedRegions();
    }
    
    private void markOpenRegions() {//mark open from border
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') markBFS(i, 0);
            if (board[i][n-1] == 'O') markBFS(i, n-1);
        }
        
        for (int j = 1; j < n-1; j++) {
            if (board[0][j] == 'O') markBFS(0, j);
            if (board[m-1][j] == 'O') markBFS(m-1, j);
        }
    }
    
    private void markDFS(int i, int j) { // cannot pass large case
        board[i][j] = 'Y';
        
        if (isOpen(i-1, j)) markDFS(i-1, j);
        if (isOpen(i+1, j)) markDFS(i+1, j);
        if (isOpen(i, j-1)) markDFS(i, j-1);
        if (isOpen(i, j+1)) markDFS(i, j+1);
    }
    
    private void markBFS(int row, int col) {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(getKey(row, col));
        
        while (!queue.isEmpty()) {
            int key = queue.poll();
            int i = key / n;
            int j = key % n;
            board[i][j] = 'Y';
            
            if (isOpen(i-1, j)) queue.offer(getKey(i-1, j));
            if (isOpen(i+1, j)) queue.offer(getKey(i+1, j));
            if (isOpen(i, j-1)) queue.offer(getKey(i, j-1));
            if (isOpen(i, j+1)) queue.offer(getKey(i, j+1));
        }
    }
    
    private void markOpenRegionsBFS() {// only this method passes all tests
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') queue.offer(getKey(0, j));
            if (board[m-1][j] == 'O') queue.offer(getKey(m-1, j));
        }
        
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') queue.offer(getKey(i, 0));
            if (board[i][n-1] == 'O') queue.offer(getKey(i, n-1));
        }
        
        while (!queue.isEmpty()) {
            int key = queue.poll();
            int i = key / n;
            int j = key % n;
            board[i][j] = 'Y';
            
            if (isOpen(i-1, j)) queue.offer(getKey(i-1, j));
            if (isOpen(i+1, j)) queue.offer(getKey(i+1, j));
            if (isOpen(i, j-1)) queue.offer(getKey(i, j-1));
            if (isOpen(i, j+1)) queue.offer(getKey(i, j+1));
        }
    }
    
    private int getKey(int i, int j) {
        return i * n + j;
    }
    
    private boolean isOpen(int i, int j) {
        return (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'O');
    }
    
    private void setSurroundedRegions() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }
}
