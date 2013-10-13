public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        
        int[][] matrix = new int[n][n];
        int curNum = 1;
        
        for (int layer = 0; layer < n / 2; layer++) {
            for (int j = layer; j < n - 1 - layer; j++) {
                matrix[layer][j] = curNum++;
            }
            
            for (int i = layer; i < n - 1 - layer; i++) {
                matrix[i][n-1-layer] = curNum++;
            }
            
            for (int j = n - 1 - layer; j > layer; j--) {
                matrix[n-1-layer][j] = curNum++;
            }
            
            for (int i = n - 1 - layer; i > layer; i--) {
                matrix[i][layer] = curNum++;
            }
        }
        
        if (n % 2 != 0) matrix[n/2][n/2] = curNum;
        
        return matrix;
    }
}
