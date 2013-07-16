import java.util.*;
public class InsertIntervals {
   public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
       ArrayList<Interval> mergedList = new ArrayList<Interval>();
       
       int i = 0;
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

   private class Interval {
       int start;
       int end;
       Interval() { start = 0; end = 0; }
       Interval(int s, int e) { start = s; end = e; }
   }
}
