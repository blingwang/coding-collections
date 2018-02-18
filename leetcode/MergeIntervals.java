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
        
        Interval pre = intervals.get(0);
        for (Interval cur : intervals) {
            if (cur.start <= pre.end) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                mergedList.add(cur);
                pre = cur;
            }
        }
        
        mergedList.add(pre);
        return mergedList;
    }
    
    public ArrayList<Interval> mergeInplace(ArrayList<Interval> intervals) {
        if (intervals.isEmpty()) return intervals;
        
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start > i2.start) return 1;
                if (i1.start < i2.start) return -1;
                return 0;
            }
        };
        
        Collections.sort(intervals, comparator);
        
        int lastMerged = 0;
        for (int i = 1; i < intervals.size(); i++) {
            Interval pre = intervals.get(lastMerged);
            Interval cur = intervals.get(i);
            
            if (cur.start <= pre.end) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                intervals.set(++lastMerged, cur);
            }
        }
        
        for (int i = intervals.size() - 1; i > lastMerged; i--) {
            intervals.remove(i);
        }
        
        return intervals;
    }

    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
