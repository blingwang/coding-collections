public class RotateImage {
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
