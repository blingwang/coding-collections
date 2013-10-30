public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        assert(board.length == 9 && board[0].length == 9);
        return isValidRow(board) && isValidCol(board) && isValidBox(board);
    }

    private boolean isValidRow(char[][] board) {
        boolean[] curRow = new boolean[9];
        for (int row = 0; row < 9; row++) {
            Arrays.set(curRow, false);
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
            Arrays.set(curCol, false);
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
                Arrays.set(curBox, false);
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
}
