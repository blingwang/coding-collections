class Solution7Q3 {}
class Line {
    public static final double epsilon = 0.000001;
    private double slope;
    private double yIntercept;

    public Line(double s, double y) {
        slope = s;
        yIntercept = y;
    }

    public boolean intersect(Line, line2) {
        return Math.abs(slope - line2.slope) > epsilon ||
               Math.abs(yIntercept - line2.yIntercept) < epsilon;
    }
}
