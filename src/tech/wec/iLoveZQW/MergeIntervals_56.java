package tech.wec.iLoveZQW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals_56 {

    class Solution {

        class Interval{
            int start;
            int end;

            public Interval(int start, int end){
                this.start = start;
                this.end = end;
            }
        }

        public int[][] merge(int[][] intervals) {
            List<Interval> list = new ArrayList<>();
            for (int[] interval: intervals){
                Interval val = new Interval(interval[0], interval[1]);
                list.add(val);
            }
            Collections.sort(list, (t1, t2) -> {
                return t1.start < t2.start? -1 : t1.start == t2.start? 0 : 1;
            });
            LinkedList<Interval> result = new LinkedList<>();
            for (Interval interval: list){
                if (result.isEmpty() || result.getLast().end < interval.start)
                    result.add(interval);
                else
                    result.getLast().end = Math.max(result.getLast().end, interval.end);
            }
            int[][] ans = new int[result.size()][2];
            int i = 0;
            for (Interval interval: result){
                ans[i][0] = interval.start;
                ans[i][1] = interval.end;
                i++;
            }
            return ans;
        }
    }
}
