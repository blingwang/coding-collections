public class Solution1Q7{
    public void setZeros(int[][] matrix){
        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        if (n == 0) return;
        
        boolean[] row = new boolean[m];
        boolean[] column = new boolean[n];

        // store the row and column index with value 0
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // set arr[i][j] to 0 if either row i or column j has a 0
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(row[i] || column[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
