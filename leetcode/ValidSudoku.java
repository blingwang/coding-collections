public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        assert(board.length == 9 && board[0].length == 9);
        return isValidRow(board) && isValidCol(board) && isValidBox(board);
    }

    private boolean isValidRow(char[][] board) {
        boolean[] curRow = new boolean[9];
        for (int row = 0; row < 9; row++) {
            resetArray(curRow);
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
               if (c == '.') continue;
               if (curRow[c-'1'] == true) return false;
               curRow[c-'1'] = true;
            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board) {
        boolean[] curCol = new boolean[9];
        for (int col = 0; col < 9; col++) {
            resetArray(curCol);
            for (int row = 0; row < 9; row++) {
                char c = board[row][col];
                if (c == '.') continue;
                if (curCol[c-'1'] == true) return false;
                curCol[c-'1'] = true;
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board) {
        boolean[] curBox = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                resetArray(curBox);
                int startRow = i * 3;
                int startCol = j * 3;
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        char c = board[startRow+m][startCol+n];
                        if (c == '.') continue;
                        if (curBox[c-'1'] == true) return false;
                        curBox[c-'1'] = true;
                    }
                }
            }
        }
        return true;
    }

    private void resetArray(boolean[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = false;
        }
    }
        
    public boolean isValidSudokuSlow(char[][] board) {
        assert(board.length == 9 && board[0].length == 9);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                if (!isRowValid(board, c, i, j) || !isColValid(board, c, i, j) ||
                    !isBoxValid(board, c, i, j)) {
                        return false;
                    }
            }
        }
        return true;
    }

    private boolean isRowValid(char[][] board, char num, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isColValid(char[][] board, char num, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == num) {
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
