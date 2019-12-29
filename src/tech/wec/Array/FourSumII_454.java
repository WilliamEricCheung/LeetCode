package tech.wec.Array;

import java.util.HashMap;
import java.util.Map;

public class FourSumII_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map1 = getSumMap(A, B);
        Map<Integer, Integer> map2 = getSumMap(C, D);
        int result = 0;
        for (Map.Entry<Integer, Integer> entry: map1.entrySet()){
            if (map2.containsKey(entry.getKey())){
                result += entry.getValue() * map2.get(-entry.getKey());
            }
        }
        return result;
    }

    private Map<Integer, Integer> getSumMap(int[] a, int[] b){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i =  0; i < a.length; i++){
            for (int j = 0; j < b.length; j++){
                map.put(a[i] + b[j], map.getOrDefault(a[i] + b[j], 0) + 1);
            }
        }
        return map;
    }
}
