import java.util.*;
class Solution7Q6 {
    public Line findBestLine(GraphPoint[] points) {
        Line bestLine = null;
        int bestCount = 0;
        HashMap<Double, ArrayList<Line>> linesBySlope = 
            new HashMap<Double, ArrayList<Line>>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line line = new Line(points[i], points[j]);
                insertLine(linesBySlope, line);
                int count = countEquivLines(linesBySlope, line);
                if (count > bestCount) {
                    bestLine = line;
                    bestCount = count;
                }
            }
        }
        return bestLine;
    }

    private int countEquivalentLines(ArrayList<Line> lines, Line line) {
        if (lines == null) return 0;
        int count = 0;
        for (Line parallelLine : lines) {
            if (parallelLine.isEquivalent(line)) {
                count++;
            }
        }
        return count;
    }

    private int countEquivLines(HashMap<Double, ArrayList<Line>> linesBySlope, Line line) {
        double key = Line.floorToNearestEpsilon(line.slope);
        double eps = Line.epsilon;
        int count = countEquivalentLines(linesBySlope.get(key), line) +
                countEquivalentLines(linesBySlope.get(key - eps), line) + 
                countEquivalentLines(linesBySlope.get(key + eps), line);
        return count;
    }

    private void insertLine(HashMap<Double, ArrayList<Line>> linesBySlope, Line line) {
        ArrayList<Line> lines = null;
        double key = line.floorToNearestEpsilon(line.slope);
        if (!linesBySlope.containsKey(key)) {
            lines = new ArrayList<Line>();
            linesBySlope.put(key, lines);
        } else {
            lines = linesBySlope.get(key);
        }
        lines.add(line);
    }

}

class GraphPoint {
    public double x, y;
    public GraphPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Line {
    public static double epsilon = .0001;
    public double slope, intercept;
    private boolean infinite_slope = false;

    public Line(GraphPoint p, GraphPoint q) {
        if (Math.abs(p.x - q.x) > epsilon) { // if x's are different
            slope = (p.y - q.y) / (p.x - q.x); // compute slope
            intercept = p.y - slope * p.x; // y intercept from y = mx + b
        } else {
            infinite_slope = true;
            intercept = p.x; // x-intercept, since slope is infinite
        }
    }

    public static double floorToNearestEpsilon(double d) {
        int r = (int) (d / epsilon);
        return ((double)r) * epsilon;
    }

    public boolean isEquivalent(double a, double b) {
        return Math.abs(a - b) < epsilon;
    }

    public boolean isEquivalent(Object o) {
        Line l = (Line)o;
        if (isEquivalent(l.slope, slope) && isEquivalent(l.intercept, intercept)) {
            return true;
        }
        return false;
    }
}

