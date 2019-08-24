package tech.wec.Facebook;

import java.util.*;

public class MergeIntervals_56 {
    private class Interval{
        int start;
        int end;
        public Interval(int start,int end){
            this.start= start;
            this.end=end;
        }
    }
    private class intervalComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval o1, Interval o2) {
//            return o1.start < o2.start? -1: o1.end == o2.end? 0:1;
            if (o1.start<o2.start)
                return -1;
            else if (o1.start == o2.start)
                return 0;
            else
                return 1;
        }
    }
    public int[][] merge(int[][] intervals) {
        List<Interval> vals = new ArrayList<>();
        for (int i =0;i<intervals.length;i++){
            Interval interval = new Interval(intervals[i][0], intervals[i][1]);
            vals.add(interval);
        }
        Collections.sort(vals, new intervalComparator());
        LinkedList<Interval> ans = new LinkedList<>();
        for (Interval interval: vals){
            if (ans.isEmpty() || ans.getLast().end < interval.start){
                ans.add(interval);
            }else{
                // merge intervals
                ans.getLast().end = Math.max(ans.getLast().end, interval.end);
            }
        }
        int[][] result = new int[ans.size()][2];
        int i = 0;
        for (Interval interval: ans){
            result[i][0] = interval.start;
            result[i][1] = interval.end;
            i++;
        }
        return result;
    }
}
