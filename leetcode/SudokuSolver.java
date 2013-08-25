public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0);
    }

    private boolean solveSudoku(char[][] board, int count) {
        if (count == 81) return true; // base case
        
        int i = count / 9;
        int j = count % 9;
        
        // skip filled cell
        if (board[i][j] != '.') return solveSudoku(board, count+1);
        
        for ( char k = '1'; k <= '9'; k++) {                    
            if (isValidSudoku(board, k, i, j)) {// backtrack if invalid
                board[i][j] = k;
                if (solveSudoku(board, count+1)) { // recurse
                    return true; // found solution: no more dfs
                }
            }
        }
        
        board[i][j] = '.'; // clean up
        
        return false;
    }

    private boolean isValidSudoku(char[][] board, char c, int i, int j) {     
        return isRowValid(board, c, i, j) && isColValid(board, c, i, j) && 
               isBoxValid(board, c, i, j);
    }

    private boolean isRowValid(char[][] board, char num, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (i !=col && board[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isColValid(char[][] board, char num, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (i != row && board[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isBoxValid(char[][] board, char num, int row, int col) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int r = startRow + i;
                int c = startCol + j;
                if (r == row && c == col) continue; 
                if (board[r][c] == num) return false;
            }
        }
        return true;
    }
}
