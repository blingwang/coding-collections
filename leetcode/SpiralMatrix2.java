public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        
        int[][] matrix= new int[n][n];
        int curNum = 1;
        
        for(int layer = 0; (layer+1) * 2 <= n; layer++) {
            for (int j = layer; j < n-layer-1; j++) {
                matrix[layer][j] = curNum++;
            }
            
            for (int i = layer; i < n-layer-1; i++) {
                matrix[i][n-layer-1] = curNum++;
            }
            
            for (int j = n-layer-1; j > layer; j--) {
                matrix[n-layer-1][j] = curNum++;
            }
            
            for (int i = n-layer-1; i > layer; i--) {
                matrix[i][layer] = curNum++;
            }
        }
        
        if (n % 2 != 0) matrix[n/2][n/2] = curNum;
        
        return matrix;
    }
}
