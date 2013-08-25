import java.util.*;

public class PathFinder {
    private int[][] grid; // 0: free; 1: blocked
    private int m, n;
    private ArrayList<Point> result;
    private boolean[][] visited;

    public ArrayList<Point> findPath(int[][] grid) {
        this.grid = grid;
        result = new ArrayList<Point>();
        m = grid.length;
        if (m == 0) return result;
        n = grid[0].length;
        if (n == 0) return result;
        visited = new boolean[m][n];

        Point[] path = new Point[m+n-1];
        dfs(0, 0, path);

        return result;
    }

    private void dfs(int x, int y, Point[] path) {
        if (!result.isEmpty()) return; // path already found
        if (x >= m || y >= n) return; // off limits
        if (visited[x][y]) return; // already visited
        
        visited[x][y] = true;
        if (grid[x][y] == 1) return;// dead end: backtrack
        path[x+y] = new Point(x, y);

        if (x == m-1 && y == n-1) { // base case
            process(path);
            return;
        }

        dfs(x + 1, y, path);
        dfs(x, y + 1, path);         
    }

    private void process(Point[] path) {
        for (Point p : path) {
            result.add(p);
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,1}, {0,0,0,0}, {0,1,0,0}};
        PathFinder pf = new PathFinder();

        for (Point p : pf.findPath(grid)) {
            p.print();
        }

        System.out.println();
    }

    private static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        void print() {
            System.out.print("(" + x + "," + y + ")" + " ");
        }
    }
} 
