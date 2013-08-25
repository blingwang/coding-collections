import java.util.*;
class Solution9Q2 {
    private Random rnd = new Random();
    
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
        if (cache.containsKey(p)) { // already visited this cell
            return cache.get(p);
        }

        if(x == 0 && y ==0) {
            return true; // found a path
        }

        boolean success = false;

        if (x >= 1 && isFree(x - 1, y)) { // Try right
            success = getPath(x - 1, y, path, cache); // Free! Go right
        }

        if (!success && y >= 1 && isFree(x, y - 1)) { // Try down
            success = getPath(x, y - 1, path, cache); // Free! Go down
        }

        if (success) {
            path.add(p); // Right way! add to path
        }

        cache.put(p, success); // cache result
        return success;
    }

    private boolean isFree(int x, int y) {
        return rnd.nextBoolean();
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
