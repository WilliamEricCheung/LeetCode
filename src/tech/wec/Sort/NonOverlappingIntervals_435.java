package tech.wec.Sort;

import java.util.*;

public class NonOverlappingIntervals_435 {
    class Solution {
        class Interval{
            int start;
            int end;
            public Interval(int start, int end){
                this.start = start;
                this.end = end;
            }
        }
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) return 0;
            List<Interval> list = new ArrayList<>();
            for (int[] interval: intervals)
                list.add(new Interval(interval[0], interval[1]));
            Collections.sort(list, new Comparator<Interval>() {
                @Override
                public int compare(Interval interval, Interval t1) {
                    return interval.end - t1.end;
                }
            });
            int end = list.get(0).end;
            int cnt = 1;
            for (Interval interval: list){
                if (interval.start >= end){
                    end = interval.end;
                    cnt++;
                }
            }
            return intervals.length - cnt;
        }
    }
}
