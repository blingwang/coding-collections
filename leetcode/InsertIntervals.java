import java.util.*;
public class InsertIntervals {
   public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
       ArrayList<Interval> mergedList = new ArrayList<Interval>();
       
       int i = 0;
       // if origion data structure can be efficently inserted, use binary search
       while (i < intervals.size() && newInterval.start > intervals.get(i).end) {
           mergedList.add(intervals.get(i++));
       }
       
       while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
           newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
           newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
           i++;
       }
       
       mergedList.add(newInterval);
       
       while(i < intervals.size()) {
           mergedList.add(intervals.get(i++));
       }
       
       return mergedList;
   }
   
   public ArrayList<Interval> insertInplace(ArrayList<Interval> intervals, Interval newInterval) {
        int insertPos = findInsertPosition(intervals, newInterval);
        
        int i = insertPos;
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        
        if (i == insertPos) { // no overlap
            intervals.add(insertPos, newInterval);
        } else { // shift
           intervals.set(insertPos, newInterval); 
           int shift = i - insertPos - 1;
           if (shift > 0) {
               while (i < intervals.size()) {
                   intervals.set(i-shift, intervals.get(i));
                   i++;
               }
               while(shift > 0) {
                   intervals.remove(intervals.size()-1);
                   shift--;
               }
           }
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
