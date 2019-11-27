package tech.wec.HashTable;

import javafx.util.Pair;

import java.util.*;

public class TopKFrequentElements_347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for (Map.Entry entry: map.entrySet()){
            pairs.add(new Pair(entry.getKey(), entry.getValue()));
        }
        Collections.sort(pairs, (p1, p2)->{
            return p2.getValue() - p1.getValue();
        });
        for (int i = 0; i < k; i++){
            result.add(pairs.get(i).getKey());
        }
        return result;
    }
}
