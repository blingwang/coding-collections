public class Solution1Q6{
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

