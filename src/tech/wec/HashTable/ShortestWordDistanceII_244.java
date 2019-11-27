package tech.wec.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII_244 {
    class WordDistance {

        Map<String, List<Integer>> map;

        public WordDistance(String[] words) {
            map = new HashMap<>();
            int idx = 0;
            for (String word: words){
                List<Integer> list = map.getOrDefault(word, new ArrayList<>());
                list.add(idx++);
                map.put(word, list);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            int l1 = 0, l2 = 0, min = Integer.MAX_VALUE;
            while(l1 < list1.size() && l2 < list2.size()){
                min = Math.min(min, Math.abs(list1.get(l1) - list2.get(l2)));
                if (list1.get(l1)<list2.get(l2)) l1++;
                else l2++;
            }
            return min;
        }
    }
}
