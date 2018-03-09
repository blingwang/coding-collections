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

public class IntervalMerge {
    public List<Interval> mergeList(List<Interval> l1, List<Interval> l2) {
        if (l1.isEmpty()) return l2;
        if (l2.isEmpty()) return l1;

        l1.sort(Comparator.comparingInt(i -> i.start));
        l2.sort(Comparator.comparingInt(i -> i.start));

        Interval min =  l1.get(0).start < l2.get(0).start ? l1.get(0) : l2.get(0);
        int preStart = min.start;
        int preEnd = min.end;

        List<Interval> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        for (int k = 0; k < l1.size() + l2.size(); k++) {
            Interval cur;
            if (i >= l1.size()) {
                cur = l2.get(j);
                j++;
            } else if (j >= l2.size()) {
                cur = l1.get(i);
                i++;
            } else if (l1.get(i).start <= l2.get(j).start) {
                cur = l1.get(i);
                i++;
            } else {
                cur  = l2.get(j);
                j++;
            }

            if (preEnd < cur.start) {
                result.add(new Interval(preStart, preEnd));
                preStart = cur.start;
                preEnd = cur.end;
            } else {
                preEnd = Math.max(preEnd, cur.end);
            }
        }
        
        result.add(new Interval(preStart, preEnd));
        return result;
    }

    public static void main(String[] args) {
        List<Interval> l1 = new ArrayList<>();
        l1.add(new Interval(1, 5));
        l1.add(new Interval(10, 14));
        l1.add(new Interval(16, 18));
        l1.add(new Interval(20, 24));
        l1.add(new Interval(30, 38));
        List<Interval> l2 = new ArrayList<>();
        l2.add(new Interval(2, 6));
        l2.add(new Interval(8, 10));
        l2.add(new Interval(11, 20));

        IntervalMerge intervalMerge = new IntervalMerge();
        List<Interval> result = intervalMerge.mergeList(l1, l2);
        for (Interval i1 : result) {
            System.out.println(i1.start + ", " + i1.end);
        }
    }

}
