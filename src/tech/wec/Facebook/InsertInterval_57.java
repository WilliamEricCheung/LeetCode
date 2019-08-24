package tech.wec.Facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval_57 {
    private class Interval{
        int start;
        int end;
        public Interval(int start,int end){
            this.start= start;
            this.end=end;
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0)
            return new int[][]{newInterval};

        List<Interval> vals = new ArrayList<>();
        boolean added = false;
        for (int i =0;i<intervals.length;i++){
            if (!added&&intervals[i][0] >= newInterval[0]) {
                Interval interval = new Interval(newInterval[0], newInterval[1]);
                vals.add(interval);
                added = true;
            }
            Interval interval = new Interval(intervals[i][0], intervals[i][1]);
            vals.add(interval);
        }
        if (!added){
            Interval interval = new Interval(newInterval[0], newInterval[1]);
            vals.add(interval);
            added = true;
        }
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
