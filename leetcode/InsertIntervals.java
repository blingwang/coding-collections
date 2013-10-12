import java.util.*;
public class InsertIntervals {
   public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> mergedList = new ArrayList<Interval>();
        int i = 0;
        
        // if origion data structure can be efficently inserted, use binary search
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            mergedList.add(intervals.get(i));
            i++;
        }
        
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        mergedList.add(newInterval);
        
        while (i < intervals.size()) {
            mergedList.add(intervals.get(i));
            i++;
        }
        
        return mergedList;
    }
   
   public ArrayList<Interval> insertInplace(ArrayList<Interval> intervals, Interval newInterval) {
        int insertIndex = findInsertPosition(intervals, newInterval);
        
        // merge intervals
        int i = insertIndex;
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        
        if (i == insertIndex) { // no overlap: insert into list
            intervals.add(insertIndex, newInterval); // arraylist add: insert or append
        } else {
            intervals.set(insertIndex, newInterval);
            int j = insertIndex + 1;
            while (i < intervals.size()) intervals.set(j++, intervals.get(i++));//shift
            while (i > j) intervals.remove(--i); // remove
        }
        
        return intervals;
    }
    
    private int findInsertPosition(ArrayList<Interval> intervals, Interval target) {
        int lo = 0, hi = intervals.size() - 1;
        int bestSoFar = intervals.size();
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (intervals.get(mid).end == target.start) {
                bestSoFar = mid;
                break;
            } else if (intervals.get(mid).end > target.start) {
                bestSoFar = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return bestSoFar;
    }

   private class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
   }
}
