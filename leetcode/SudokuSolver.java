public class SudokuSolver {
    private char[][] board;
    
    public void solveSudoku(char[][] board) {
        this.board = board;
        solve(0);
    }

    private boolean solve(int count) {
        if (count == 81) return true; // base case
        
        int i = count / 9;
        int j = count % 9;
        
        if (board[i][j] != '.') return solve(count+1);// skip filled cell
        
        // try all possibilities
        for ( char k = '1'; k <= '9'; k++) {  
            board[i][j] = k;
            // if not backtrack, recurse until solution found
            if (isValidSudoku(i, j) && solve(count+1)) return true;
        }
        
        board[i][j] = '.'; // clean up
        
        return false;
    }

    private boolean isValidSudoku(int i, int j) {     
        return isRowValid(i, j) && isColValid(i, j) && 
               isBoxValid(i, j);
    }

    private boolean isRowValid(int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (i !=col && board[row][i] == board[row][col]) return false;
        }
        
        return true;
    }

    private boolean isColValid(int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == board[row][col]) return false;
        }
        
        return true;
    }

    private boolean isBoxValid(int row, int col) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int r = startRow + i;
                int c = startCol + j;
                if (r == row && c == col) continue; 
                if (board[r][c] == board[row][col]) return false;
            }
        }
        
        return true;
    }
}
