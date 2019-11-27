package tech.wec.HashTable;

import javafx.util.Pair;

import java.util.*;

public class TopKFrequentWords_692 {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            List<String> result = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();
            List<Pair<String ,Integer>> list = new ArrayList<>();
            for (String word: words)
                map.put(word, map.getOrDefault(word, 0) + 1);
            for (Map.Entry entry: map.entrySet())
                list.add(new Pair(entry.getKey(), entry.getValue()));
            Collections.sort(list, (p1, p2) -> {
                if (p1.getValue()!= p2.getValue())
                    return p2.getValue() - p1.getValue();
                else
                    return p1.getKey().compareTo(p2.getKey());
            });
            for (int i = 0; i < k; i++)
                result.add(list.get(i).getKey());
            return result;
        }
    }
}
