public class MinPathSum {
    private int[][] grid;
    int m, n;
    private int[][] cache;

    public int minPathSum(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cache[i][j] = -1;
            }
        }
        
        return minPathSum(m-1, n-1);  
    }

    private int minPathSum(int i, int j) {
        if ((i == 0 && j < 0) || (i < 0 && j == 0)) return 0;      
        if (i < 0 || j < 0) return Integer.MAX_VALUE;       
        if (cache[i][j] >= 0) return cache[i][j];
        
        int num = grid[i][j];
        int min = Math.min(minPathSum(i-1, j), minPathSum(i, j-1)) + num;
        cache[i][j] = min;
        
        return min;
    }
}
