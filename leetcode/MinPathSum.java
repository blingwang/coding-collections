public class MinPathSum {
    // Solution 1 using memorization
    private int m, n;
    private Map<Integer, Integer> cache;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        
        cache = new HashMap<Integer, Integer>();
        return minPathSum(grid, m - 1, n - 1);
    }
    
    private int minPathSum(int[][] grid, int x, int y) {
        if (x < 0 || y < 0) return Integer.MAX_VALUE;
        if (x == 0 && y == 0) return grid[0][0];
        
        int key = x * n + y;
        if (cache.containsKey(key)) return cache.get(key);
        
        int minSum = grid[x][y] + Math.min(minPathSum(grid, x-1, y), 
                                           minPathSum(grid, x, y-1));
        
        cache.put(key, minSum);
        return minSum;
    }
    
    // Solution 2 using DP: store in matrix
    public int minPathSumDP2(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        
        int[][] pathSums = new int[m][n];
        pathSums[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++) {
            pathSums[i][0] = pathSums[i-1][0] + grid[i][0];
        }
        
        for (int j = 1; j < n; j++) {
            pathSums[0][j] = pathSums[0][j-1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathSums[i][j] = Math.min(pathSums[i-1][j], pathSums[i][j-1]) + 
                                 grid[i][j];
            }
        }
        
        return pathSums[m-1][n-1];
    }
    
    // Solution 3 using DP: store in array
    public int minPathSumDP1(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        
        int[] pathSums = new int[n];
        
        pathSums[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            pathSums[j] = pathSums[j-1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            pathSums[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                pathSums[j] = Math.min(pathSums[j], pathSums[j-1]) + grid[i][j];
            }
        }
        
        return pathSums[n-1];
    }
}
