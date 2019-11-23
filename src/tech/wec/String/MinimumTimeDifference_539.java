package tech.wec.String;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference_539 {
    public int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        for (int i = 0; i < times.length; i++){
            String[] hourMin = timePoints.get(i).split(":");
            times[i] = Integer.parseInt(hourMin[0]) * 60 + Integer.parseInt(hourMin[1]);
        }
        Arrays.sort(times);
        int min = Integer.MAX_VALUE;
        int diff = 0;
        for (int i = times.length - 1; i > 0; i--){
            diff = times[i] - times[i - 1];
            if (diff < min) min = diff;
        }

        if (times.length >= 2){
            int last = times[times.length - 1];
            int first = times[0];
            min = Math.min(min, (1440 - last + first));
        }
        return min;
    }
}
