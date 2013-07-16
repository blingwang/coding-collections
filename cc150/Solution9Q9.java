import java.util.*;
class Solution9Q9 {
    int GRID_SIZE = 8;

    void placeQueens(int row, int[] columns, ArrayList<int[]> results) {
        if (row == GRID_SIZE) { // Found valid placement
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col; // Place queen
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

   boolean checkValid(int[] columns, int row, int column) {
        for (int oldRow = 0; oldRow < row; oldRow++) {
            int oldColumn = columns[oldRow];
            if (oldColumn == column) { // same column
               return false;
            }

            int columnDistance = Math.abs(oldColumn - column);
            int rowDistance = row - oldRow;
            if (columnDistance == rowDistance) { // same diagonal
                return false;
            }
        }
        return true;
   } 
} 
