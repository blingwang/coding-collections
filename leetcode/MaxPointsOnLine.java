public class MaxPointsOnLine {
    public int maxPoints(Point[] points) {
        if (allSamePoints(points)) return points.length;
        int maxPoints = 0;
        
        // count all points on each line(defined by two diff points)
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (samePoint(points[i], points[j])) continue;
                
                int numPoints = 0;
                for (int k = 0; k < points.length; k++) {
                    if (sameLine(points[i], points[j], points[k])) numPoints++;
                }
                
                maxPoints = Math.max(maxPoints, numPoints);
            }
        }
        
        return maxPoints;
    }
    
    private boolean allSamePoints(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (!samePoint(points[i], points[j])) return false;
            }
        }
        return true;
    }
    
    private boolean samePoint(Point p1, Point p2) {
        return p1.x == p2.x && p1.y == p2.y;
    }
    
    // check if p3 on line p1p2
    private boolean sameLine(Point p1, Point p2, Point p3) {
        assert(!samePoint(p1, p2));
        return (p2.y-p1.y) * (p3.x-p2.x) == (p3.y-p2.y) * (p2.x-p1.x);
    }
    
    private class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b;}
    }
}
