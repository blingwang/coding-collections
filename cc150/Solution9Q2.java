import java.util.*;
class Solution9Q2 {
    private Random rand = new Random();
    
    // count paths: 0 for reee; 1 for obstacle
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
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
    
    // find a path in a obstacle grid
    public ArrayList<Point> getPath(int x, int y) {
        ArrayList<Point> path = new ArrayList<Point>();
        HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();

       getPath(x, y, path, cache);

       return path;
    }
    
    private boolean getPath(int x, int y, ArrayList<Point> path, 
            HashMap<Point, Boolean> cache) {
        Point p = new Point(x, y);
        
        if (cache.containsKey(p)) {
            return cache.get(p);
        }

        if(x == 0 && y ==0) {
            return true;
        }

        boolean success = false;

        if (x >= 1 && isFree(x - 1, y)) {
            success = getPath(x - 1, y, path, cache);
        }

        if (!success && y >= 1 && isFree(x, y - 1)) {
            success = getPath(x, y - 1, path, cache);
        }

        if (success) {
            path.add(p); 
        }

        cache.put(p, success);
        
        return success;
    }

    private boolean isFree(int x, int y) {
        return rand.nextBoolean();
    }

    private class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
