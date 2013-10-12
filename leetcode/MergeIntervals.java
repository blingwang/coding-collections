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
        mergedList.add(pre);
        for (Interval cur : intervals) {
            if (cur.start <= pre.end) {
                pre.end = Math.max(pre.end, cur.end);
            } else {
                mergedList.add(cur);
                pre = cur;
            }
        }
        
        return mergedList;
    }
    
    public ArrayList<Interval> mergeInplace(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return intervals;
        
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if (i1.start < i2.start) return -1;
                if (i1.start > i2.start) return 1;
                return 0;
            }
        };
        
        Collections.sort(intervals, comparator);
        
        int lastIndex = 0;
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            Interval last = intervals.get(lastIndex);
            
            if (cur.start <= last.end) { // overlap => merge to last
                last.end = Math.max(last.end, cur.end);
            } else { // not overlap => append to last
                lastIndex++;
                intervals.set(lastIndex, cur);
            }
        }
        
        for (int i = intervals.size() - 1; i > lastIndex; i--) {
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
