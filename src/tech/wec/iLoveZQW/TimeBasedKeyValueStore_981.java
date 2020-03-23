package tech.wec.iLoveZQW;

import javafx.util.Pair;

import java.util.*;

public class TimeBasedKeyValueStore_981 {
    class TimeMap {

        private Map<String, TreeMap<Integer, String>> lib;

        /** Initialize your data structure here. */
        public TimeMap() {
            lib = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!lib.containsKey(key)){
                lib.put(key, new TreeMap<>());
            }
            lib.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!lib.containsKey(key)) return "";
            TreeMap<Integer, String> treeMap = lib.get(key);
            Integer t = treeMap.floorKey(timestamp);
            return t == null? "": treeMap.get(t);
        }
    }
}
