import java.util.*;
public class SpiralMatrix {
    ArrayList<Integer> result;
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        result = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        if (n == 0) return result;
        
        sprialOrderAddMatrix(matrix, m, n, 0);
        
        return result;
    }

    private void sprialOrderAddMatrix(int[][] matrix, int m, int n, int layer) {
        if (m <= 0 || n <= 0) return;
        
        if (m == 1) {
            for (int j = 0; j < n; j++) {
                result.add(matrix[layer][layer+j]);
            }
            return;
        }
        
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                result.add(matrix[layer+i][layer]);
            }
            return;
        }
        
        for (int j = 0; j < n - 1; j++) {
            result.add(matrix[layer][layer+j]);
        }
        
        for (int i = 0; i < m - 1; i++) {
            result.add(matrix[layer+i][layer+n-1]);
        }
        
        for (int j = 0; j < n - 1; j++) {
            result.add(matrix[layer+m-1][layer+n-j-1]);
        }
        
        for (int i = 0; i < m - 1; i++) {
            result.add(matrix[layer+m-i-1][layer]);
        }
        
        sprialOrderAddMatrix(matrix, m-2, n-2, layer+1);
    }

    public ArrayList<Integer> spiralOrderIter(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        int totalLayers = (Math.min(m, n) + 1) / 2;
        int count = 0;
        
        for (int layer = 0; layer < totalLayers; layer++) {
            // single row
            if (layer * 2 == m-1) {
                for(int i = layer; i <= n -layer - 1; i++) {
                    result.add(matrix[layer][i]);
                }
                return result;
            }
            
            // single column
            if (layer * 2 == n-1) {
                for(int i = layer; i <= m - layer - 1; i++) {
                    result.add(matrix[i][n-layer-1]);
                }
                return result;
            }
            
            // top row
            for(int i = layer; i < n -layer - 1; i++) {
                result.add(matrix[layer][i]);
            }
            
            // right column
            for (int i = layer; i < m - layer - 1; i++) {
                result.add(matrix[i][n-layer-1]);
            }
            
            // bottom row
            for (int i = n - layer - 1; i > layer; i--) {
                result.add(matrix[m-layer-1][i]);
            }
            
            // left column
            for (int i = m -layer - 1; i > layer; i--) {
                result.add(matrix[i][layer]);
            }
        }
        
        return result;
    }
    
    public ArrayList<Integer> spiralOrderIter2(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        if (n == 0) return result;
        
        int layer = 0, rows = m, cols = n; 
        while (rows > 0 && cols > 0) {
            if (rows == 1) {
                for (int j = 0; j < cols; j++) {
                    result.add(matrix[layer][layer+j]);
                }
                return result;
            }
            
            if (cols == 1) {
                for (int i = 0; i < rows; i++) {
                    result.add(matrix[layer+i][layer]);
                }
                return result;
            }
            
            for (int j = 0; j < cols - 1; j++) {
                result.add(matrix[layer][layer+j]);
            }
            
            for (int i = 0; i < rows - 1; i++) {
                result.add(matrix[layer+i][n-1-layer]);
            }
            
            for (int j = cols - 1; j > 0; j--) {
                result.add(matrix[m-1-layer][layer+j]);
            }
            
            for (int i = rows - 1; i > 0; i--) {
                result.add(matrix[layer+i][layer]);
            }
            
            layer++;
            rows -= 2;
            cols -= 2;
        }
        
        return result;
    }
}
