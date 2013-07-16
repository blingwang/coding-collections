import java.util.*;
class Solution17Q2 {
    private HashMap<Integer, Integer> winnerHashTable;
    private enum Piece {Empty, Red, Blue}

    public int hasWon1(int board) {
        return winnerHashTable.get(board);
    }

    public static int convertBoardToInt(char[][] board) {
        int factor = 1;
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int v = 0; 
                if (board[i][j] == 'x') {
                    v = 1;
                } else if (board[i][j] == 'o') {
                    v = 2;
                }

                sum += v * factor;
                factor *= 3;
            }
        }

        return sum;
    }

    public Piece hasWon1(Piece[][] board) {
        for (int i = 0; i < board.length; i++) {
            // check rows
            if (board[i][0] != Piece.Empty &&
                board[i][0] == board[i][1] &&
                board[i][0] == board[i][2]) {
                return board[i][0];
            }

            // check columns
            if (board[0][i] != Piece.Empty &&
                board[0][i] == board[1][i] &&
                board[0][i] == board[2][i]) {
                return board[0][i];
            }

            // check diagonal
            if (board[0][0] != Piece.Empty &&
                board[0][0] == board[1][1] &&
                board[0][0] == board[1][1]) {
                return board[0][0];
            }

            // check reverse diagonal
            if (board[2][0] != Piece.Empty &&
                board[2][0] == board[1][1] && 
                board[2][0] == board[0][2]) {
                return board[2][0];
            }
        }
        return Piece.Empty;
    }

    public Piece hasWon3(Piece[][] board) {
        int N = board.length;
        
        // check rows
        for (int row = 0; row < N; row++) {
            if (board[row][0] != Piece.Empty) {
                for (int col = 1; col < N; col++) {
                    if (board[row][col] != board[row][0]) {
                        break;
                    }

                    if (col == N) return board[row][0];
                }
            }
        }

        // check columns
        for (int col = 0; col < N; col++) {
            if (board[0][col] != Piece.Empty) {
                for (int row = 1; row < N; row++) {
                    if (board[row][col] != board[0][col]) {
                        break;
                    }

                    if (row == N) return board[0][col];
                }
            }
        }

        // check diagonal (top left to bottom right)
        if (board[0][0] != Piece.Empty) {
            for (int row = 1; row < N; row++) {
                if (board[row][row] != board[0][0]) {
                    break;
                }

                if (row == N) return board[0][0];
            }
        }

        // check diagonal (top left to bottom right)
        if (board[N-1][0] != Piece.Empty) {
            for (int row = 1; row < N; row++) {
                if (board[N-row-1][row] != board[N-1][0]) {
                    break;
                }

                if (row == N) return board[N-1][0];
            }
        }

        return Piece.Empty;
    }
}

