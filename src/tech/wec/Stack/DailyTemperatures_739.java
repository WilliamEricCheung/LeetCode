package tech.wec.Stack;

import java.util.Arrays;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Arrays.fill(result, 0);
        for (int i = T.length - 2; i >= 0; i--){
            int tp = T[i], tNext = i+1;
            int gap = 1;
            while(tp >= T[tNext] && result[tNext] != 0){
                gap += result[tNext];
                tNext = result[tNext] + tNext;
            }
            result[i] = gap;
            if(tp >= T[tNext] && result[tNext] == 0) result[i] = 0;
        }
        return result;
    }
}
