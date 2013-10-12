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
        
        for (int layer = 0; layer < n/2; layer++) { // skip single core element
            for (int i = layer; i < n - 1 - layer; i++) {
                int temp = matrix[layer][i];
                matrix[layer][i] = matrix[n-1-i][layer];
                matrix[n-1-i][layer] = matrix[n-1-layer][n-1-i];
                matrix[n-1-layer][n-1-i] = matrix[i][n-1-layer];
                matrix[i][n-1-layer] = temp;
            }
        }
    }
}
