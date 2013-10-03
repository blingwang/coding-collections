public class TicTacToe{
enum State{Blank, X, O};

private final int n = 3;
private State[][] board = new State[n][n];
private int moveCount;

public void Move(int x, int y, State s){
    if(board[x][y] == State.Blank){
        board[x][y] = s;
    }

    moveCount++;

    /*check end conditions*/

    //check col
    for(int i = 0; i < n; i++){
        if(board[x][i] != s) break;
        if(i == n-1){
            //report win for s
        }
    }

    //check row
    for(int i = 0; i < n; i++){
        if(board[i][y] != s) break;
        if(i == n-1){
            //report win for s
        }
    }

    //check diag
    if(x == y){
        //we're on a diagonal
        for(int i = 0; i < n; i++){
            if(board[i][i] != s) break;
            if(i == n-1){
                //report win for s
            }
        }
    }

    //check anti diag
    if(x + y == n-1){
    for(int i = 0;i<n;i++){
        if(board[i][(n-1)-i] != s) break;
        if(i == n-1){
            //report win for s
        }
    }
    }

    //check draw
    if(moveCount == (n^2 - 1)){
        //report draw
    }
}
}
