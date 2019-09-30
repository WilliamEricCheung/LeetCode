package tech.wec.Google;

import java.util.*;

public class MeetingRoomsII_253 {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        Integer[] start = new Integer[intervals.length];
        Integer[] end = new Integer[intervals.length];

        for (int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;
            }
        });

        Arrays.sort(end, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;
            }
        });

        int startPtr = 0, endPtr = 0;
        int usedRooms = 0;
        while(startPtr < intervals.length){
            if (start[startPtr] >= end[endPtr]){
                usedRooms--;
                endPtr++;
            }
            usedRooms++;
            startPtr++;
        }
        return usedRooms;
    }
}
