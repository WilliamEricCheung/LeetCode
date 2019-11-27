package tech.wec.HashTable;

import javafx.util.Pair;

import java.util.*;

public class FindCommonCharacters_1002 {
    class Solution {
        public List<String> commonChars(String[] A) {
            // key for char, value for index-number
            Map<Character, Map<Integer, Integer>> map = new HashMap<>();
            for (int i = 0; i < A.length; i++){
                String a = A[i];
                for (int j = 0; j < a.length(); j++){
                    Map<Integer, Integer> value = map.getOrDefault(a.charAt(j), new HashMap<>());
                    value.put(i, value.getOrDefault(i, 0) + 1);
                    map.put(a.charAt(j), value);
                }
            }
            List<String> result = new ArrayList<>();
            for (Character ch: map.keySet()){
                if (map.get(ch).size() < A.length) continue; // 不同时存在
                int cnt = Integer.MAX_VALUE;
                for (Map.Entry<Integer, Integer> entry: map.get(ch).entrySet())
                    cnt = Math.min(entry.getValue(), cnt);
                for (int i = 0; i < cnt;i++)
                    result.add("" + ch);
            }
            return result;
        }
    }
}
