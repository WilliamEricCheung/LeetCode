package tech.wec.Greedy;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange_860 {
    public boolean lemonadeChange(int[] bills) {
        // K = credit, value = number
        Map<Integer, Integer> map  = new HashMap<>();
        map.put(5, 0); map.put(10, 0); map.put(20, 0);
        for (int i =0;i<bills.length;i++){
            if (bills[i] == 5) {
                int value5 = map.get(5);
                map.put(5, value5 + 1);
            }else if (bills[i] == 10){
                int value5 = map.get(5);
                if (value5 <= 0)
                    return false;
                map.put(5, value5 - 1);
                int value10 = map.get(10);
                map.put(10, value10 + 1);
            }else{
                int value10 = map.get(10);
                if (value10 <= 0){
                    int value5 = map.get(5);
                    if (value5 < 3)
                        return false;
                    map.put(5, value5 - 3);
                }else{
                    map.put(10, value10 - 1);
                    int value5 = map.get(5);
                    if (value5 <= 0)
                        return false;
                    map.put(5, value5 - 1);
                }
            }
        }
        return true;
    }
}
