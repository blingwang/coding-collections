public class RotateImage {
    public void rotate(int[][] matrix) {
        rotateByTranspose(matrix);
    }
    public void rotateByTranspose(int[][] matrix) {
        int n = matrix.length;
        assert(n == matrix[0].length);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {// swap half elements
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1] = temp;
            }
        }
        
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n/2; i++) {//swap n/2 elements
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
    }

    public void rotateByLayer(int[][] matrix) {
        int n = matrix.length;
        assert(n == matrix[0].length);
        
        for (int layer = 0; layer < n/2; layer++) {
            for (int i = layer; i < n - layer - 1; i++) {
                int temp = matrix[layer][i];
                matrix[layer][i] = matrix[n-i-1][layer];
                matrix[n-i-1][layer] = matrix[n-layer-1][n-i-1];
                matrix[n-layer-1][n-i-1] = matrix[i][n-layer-1];
                matrix[i][n-layer-1] = temp;
            }
        }
    }
}
