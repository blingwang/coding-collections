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
}
