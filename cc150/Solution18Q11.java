class Solution18Q11 {
    private class Subsquare {
        public int row;
        public int col;
        public int size;

        public Subsquare(int r, int c, int sz) {
            row = r;
            col = c;
            size = sz;
        }
    }

    public Subsquare findSquare(int[][] matrix) {
        for (int i = matrix.length; i > 0; i--) {
            Subsquare square = findSquareWithSize(matrix, i);
            if (square != null) return square;
        }

        return null;
    }

    private Subsquare findSquareWithSize(int[][] matrix, int squareSize) {
        /* on an edge of length N, there are (N-sz+1) sliding windows of size sz,
         * corresponding to (N-sz+1) squares of size sz
         */
        int count = matrix.length - squareSize + 1;

        // iterate throught all squares with (row, col) as its top left corner
        for (int row = 0; row < count; row++) {
            for (int col = 0; col < count; col++) {
                if (isSquare(matrix, row, col, squareSize)) {
                    return new Subsquare(row, col, squareSize);
                }
            }
        }

        return null;
    }

    private boolean isSquare(int[][] matrix, int row, int col, int size) {
        // check left and right border
        for (int i = 0; i < size; i++) {
            if (matrix[row+i][col] == 1) {
                return false;
            }
            if (matrix[row+i][col+size-1] == 1) {
                return false;
            }
        }

        // check top and bottom border
        for (int j = 1; j < size - 1; j++) {
            if (matrix[row][col+j] == 1) {
                return false;
            }

            if (matrix[row+size-1][col+j] == 1) {
                return false;
            }
        }

        return true;
    }

    private class SquareCell {
        public int zerosRight = 0;
        public int zerosBelow = 0;
        /* declaration, getters, setters */

        public SquareCell(int right, int below) {
            zerosRight = right;
            zerosBelow = below;
        }
    }

    public Subsquare findSquareFast(int[][] matrix) {
        SquareCell[][] processed = processSquare(matrix);

        for (int i = matrix.length; i > 0; i--) {
            Subsquare square = findSquareWithSize(processed, i);
            if (square != null) return square;
        }

        return null;
    }

    private Subsquare findSquareWithSize(SquareCell[][] matrix, int squareSize) {
        /* on an edge of length N, there are (N-sz+1) sliding windows of size sz,
         * corresponding to (N-sz+1) squares of size sz
         */
        int count = matrix.length - squareSize + 1;

        // iterate throught all squares with (row, col) as its top left corner
        for (int row = 0; row < count; row++) {
            for (int col = 0; col < count; col++) {
                if (isSquare(matrix, row, col, squareSize)) {
                    return new Subsquare(row, col, squareSize);
                }
            }
        }

        return null;
    }

    private boolean isSquare(SquareCell[][] matrix, int row, int col, int size) {
        SquareCell topLeft = matrix[row][col];
        SquareCell topRight = matrix[row][col+size-1];
        SquareCell bottomLeft = matrix[row+size-1][col];

        if (topLeft.zerosRight < size) { // check top edge
            return false;
        }
        if (topLeft.zerosBelow < size) { // check left edge
            return false;
        }
        if (topRight.zerosBelow < size) { // check right edge
            return false;
        } 
        if (bottomLeft.zerosRight < size) { // check bottom edge
            return false;
        }

        return true;
    }

    private SquareCell[][] processSquare(int[][] matrix) {
        SquareCell[][] processed = new SquareCell[matrix.length][matrix.length];

        for (int r = matrix.length - 1; r >= 0; r--) {
            for (int c = matrix.length - 1; c >= 0; c--) {
                int rightZeros = 0;
                int belowZeros = 0;

                // only need to process if it's a black cell
                if (matrix[r][c] == 0) {
                    rightZeros++;
                    belowZeros++;

                    if (c + 1 < matrix.length) {
                        SquareCell right = processed[r][c+1];
                        rightZeros += right.zerosRight;
                    }
                    if (r + 1 < matrix.length) {
                        SquareCell below = processed[r+1][c];
                        belowZeros += below.zerosBelow;
                    }
                }

                processed[r][c] = new SquareCell(rightZeros, belowZeros);
            }
        }

        return processed;
    }
}
