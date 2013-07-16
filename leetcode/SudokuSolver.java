public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solveSudokuRec(board, 0);
    }

    private boolean solveSudokuRec(char[][] board, int count) {
        if (count == 81) return true;
        int i = count / 9;
        int j = count % 9;
        if (board[i][j] != '.') return solveSudokuRec(board, count+1);
        for ( char k = '1'; k <= '9'; k++) {                    
            if (isValidSudoku(board, k, i, j)) {
                board[i][j] = k;
                if (solveSudokuRec(board, count+1)) {
                    return true;
                }
            }
        }
        board[i][j] = '.';    
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
