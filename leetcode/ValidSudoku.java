public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        assert(board.length == 9 && board[0].length == 9);
        return isRowValid(board) && isColValid(board) && isBoxValid(board);
    }
    
    private boolean isRowValid(char[][] board) {
        boolean[] found = new boolean[9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(found, false);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int curNum = board[i][j] - '0';
                if (found[curNum-1]) return false;
                found[curNum-1] = true;
            }
        }
        
        return true;
    }
    
    private boolean isColValid(char[][] board) {
        boolean[] found = new boolean[9];
        for (int j = 0; j < 9; j++) {
            Arrays.fill(found, false);
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') continue;
                int curNum = board[i][j] - '0';
                if (found[curNum-1]) return false;
                found[curNum-1] = true;
            }
        }
        
        return true;
    }
    
    private boolean isBoxValid(char[][] board) {
        boolean[] found = new boolean[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(found, false);
                int startRow = i * 3;
                int startCol = j * 3;
                for (int ii = 0; ii < 3; ii++) {
                    for (int jj = 0; jj < 3; jj++) {
                        if (board[startRow+ii][startCol+jj] == '.') continue;
                        int curNum = board[startRow+ii][startCol+jj] - '0';
                        if (found[curNum-1]) return false;
                        found[curNum-1] = true;
                    }
                }
            }
        }
        
        return true;
    }
}
