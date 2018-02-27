public class RotateImage {
    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry 
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
    */
    
    /*
     * anticlockwise rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
    */
    
    public void rotate(int[][] matrix) {
        rotateByTranspose(matrix);
    }
    public void rotateByTranspose(int[][] matrix) {
        int n = matrix.length;
        assert(n > 0 && n == matrix[0].length);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1-i; j++) {// swap half elements
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = temp;
            }
        }
        
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n/2; i++) {//swap n/2 elements
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
    }

    public void rotateByLayer(int[][] matrix) {
        int n = matrix.length;
        assert(n > 0 && n == matrix[0].length);
        
        for (int i = 0; i < n / 2; i++) { // i=layer, skip single core for odd n
            for (int j =i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
