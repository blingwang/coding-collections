import java.util.*;

public class SurroundedRegions {
    char[][] board;
    int m, n;

    public void solve(char[][] board) {
        if (board.length == 0) return;
        m = board.length;
        n = board[0].length;
        this.board = board;
        
        //dfsOpenToY();
        bfsOpenToY();
        setSurroundedRegions();
    }

    private void bfsOpenToY() {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') queue.offer(getKey(0, j));
            if (board[n-1][j] == 'O') queue.offer(getKey(n-1, j));
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

    private void dfsOpenToY() {
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(0, j);
            if (board[n-1][j] == 'O') dfs(n-1, j);
        }
        
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') dfs(i, 0);
            if (board[i][n-1] == 'O') dfs(i, n-1);
        }
    }

    private void dfs(int i, int j) {
        board[i][j] = 'Y';
        if (isOpen(i-1, j)) dfs(i-1, j);
        if (isOpen(i+1, j)) dfs(i+1, j);
        if (isOpen(i, j-1)) dfs(i, j-1);
        if (isOpen(i, j+1)) dfs(i, j+1);
    }

    private boolean isOpen(int i, int j) {
        return i >= 0 && i <  m && j >= 0 && j < n && board[i][j] == 'O';
    }

    private int getKey(int i, int j) {
        return i * n + j;
    }

    private void setSurroundedRegions() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }
}
