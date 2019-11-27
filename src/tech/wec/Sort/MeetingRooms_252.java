package tech.wec.Sort;

import java.util.Arrays;

public class MeetingRooms_252 {
    public boolean canAttendMeetings(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0; i < intervals.length-1; i++)
            if (end[i] > start[i+1]) return false;
        return true;
    }
}
