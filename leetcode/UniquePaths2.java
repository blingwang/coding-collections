import java.util.*;
public class UniquePaths2 {
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
}
