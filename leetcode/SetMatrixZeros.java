public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        if (n == 0) return;
        
        // use boolean array to avoid init value = 0
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    // Solution 2 using O(1) space
    public void setZeroesInplace(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        if (n == 0) return;
        
        boolean row0 = false; // use boolean to avoid init value = 0
        
        // find zero cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) row0 = true;
                    else matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // set zeros: order matters
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;   
                }
            }
        }
        
        
        if (matrix[0][0] == 0) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
        }
        
        if (row0) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;
        }      
    }
}
