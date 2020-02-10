package tech.wec.iLoveZQW;

import java.util.Arrays;
import java.util.Collections;

public class MeetingRoomsII_253 {
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            Integer[] start = new Integer[intervals.length];
            Integer[] end = new Integer[intervals.length];

            for (int i =  0; i < intervals.length; i++){
                start[i] = intervals[i][0];
                end[i] = intervals[i][1];
            }

            Arrays.sort(start, (a, b)->{
                return a - b;
            });
            Arrays.sort(end, (a, b)->{
                return a - b;
            });

            int s = 0, e = 0;
            int used = 0;
            while(s < intervals.length){
                if (start[s] >= end[e]){
                    used--;
                    e++;
                }
                used++;
                s++;
            }
            return used;
        }
    }
}
