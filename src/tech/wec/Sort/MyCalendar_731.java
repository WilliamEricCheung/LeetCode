package tech.wec.Sort;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar_731 {
    class MyCalendarTwo {

        List<int[]> calendars;
        List<int[]> overlaps;

        public MyCalendarTwo() {
            calendars = new ArrayList<>();
            overlaps = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] i : overlaps)
                if (i[0] < end && i[1] > start)
                    return false; // 已经超过2个了
            for (int[] i : calendars)
                if (i[0] < end && i[1]> start)
                    overlaps.add(new int[]{Math.max(start, i[0]), Math.min(end, i[1])});
            calendars.add(new int[]{start, end});
            return true;
        }
    }
}
