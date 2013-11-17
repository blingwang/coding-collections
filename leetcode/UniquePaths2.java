import java.util.*;
public class UniquePaths2 {
    // Solution 1 using recursion with memorization
    private int m, n;
    private Map<Integer, Integer> cache; 
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        if (m == 0) return 0;
        n = obstacleGrid[0].length;
        cache = new HashMap<Integer, Integer>();
        return uniquePaths(obstacleGrid, m-1, n-1);
    }

    public int uniquePaths(int[][] obstacleGrid, int x, int y) {
        if (x < 0 || y < 0 || obstacleGrid[x][y] == 1) return 0;
        if (x == 0 && y == 0) return 1;
        
        int key = x * n + y;  
        if (cache.containsKey(key)) return cache.get(key);
        
        int pathCount = uniquePaths(obstacleGrid, x-1, y) + 
                        uniquePaths(obstacleGrid, x, y-1);
        
        cache.put(key, pathCount);
        return pathCount;
    }
    
    // Solution 2 using DP: store in matrix
    public int uniquePathsWithObstaclesDP2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;
        
        int[][] pathCounts = new int[m][n];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0; 
        pathCounts[0][0] = 1;
        
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] != 1) pathCounts[i][0] = pathCounts[i-1][0];
        }
        
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] != 1) pathCounts[0][j] = pathCounts[0][j-1];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    pathCounts[i][j] = pathCounts[i-1][j] + pathCounts[i][j-1];
                }
            }
        }
        
        return pathCounts[m-1][n-1];
    }
    
    public int uniquePathsWithObstaclesDP3(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        assert(m > 0 && n > 0);
        
        int[][] dp = new int[m+1][n+1];
        dp[1][0] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (obstacleGrid[i-1][j-1] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m][n];
    }
    
    // Solution 3 using DP: store in array
    public int uniquePathsWithObstaclesDP1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        if (n == 0) return 0;
        int[] rowPaths = new int[n];
        if (obstacleGrid[0][0] != 1) rowPaths[0] = 1;
        
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) rowPaths[0] = 0;
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) rowPaths[j] = 0;
                else rowPaths[j] += rowPaths[j-1];
            }
        }
        
        return rowPaths[n-1];
    }
}
