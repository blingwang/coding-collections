import java.util.*;
public class UniquePaths2 {
    int m, n;
    HashMap<Integer, Integer> cache; 

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        cache = new HashMap<Integer, Integer>();
        return uniquePathsWithObstacles(obstacleGrid, m-1, n-1);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int x, int y) {
        int pathCount = 0;
        int key = x * n + y;
        
        if (cache.containsKey(key)) return cache.get(key);
        
        if (x < 0 || y < 0) pathCount = 1;
        else if (obstacleGrid[x][y] == 1) pathCount = 0;
        else if (x == 0) pathCount = uniquePathsWithObstacles(obstacleGrid, x, y-1);
        else if (y == 0) pathCount = uniquePathsWithObstacles(obstacleGrid, x-1, y);
        else pathCount = uniquePathsWithObstacles(obstacleGrid, x-1, y) + 
                         uniquePathsWithObstacles(obstacleGrid, x, y-1);
        
        cache.put(key, pathCount);
        return pathCount;
    }
}
