package com.blingwang.playground;

import java.util.*;

/**
 * @author edward
 */
class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MinMeetingRooms {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, (a, b) -> a.end - b.end);
        heap.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= heap.peek().end) {
                heap.poll();
            }
            heap.offer(intervals[i]);
        }

        return heap.size();
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        MinMeetingRooms minMeetingRooms = new MinMeetingRooms();
        int minMeetRooms = minMeetingRooms.minMeetingRooms(intervals);
        System.out.println(minMeetRooms);
    }

}
