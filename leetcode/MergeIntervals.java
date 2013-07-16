import java.util.*;
public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> mergedList = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) return mergedList;
        
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start < i2.start) return -1;
                if (i1.start > i2.start) return 1;
                return 0;
            }
        };
        
        Collections.sort(intervals, comparator);
        
        Interval last = intervals.get(0);
        mergedList.add(last);
        for (Interval cur : intervals) {
            if (cur.start <= last.end) {
                last.end = Math.max(last.end, cur.end);
            } else {
                mergedList.add(cur);
                last = cur;
            }
        }
        
        return mergedList;
    }

    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
