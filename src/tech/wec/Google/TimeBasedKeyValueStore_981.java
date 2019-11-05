package tech.wec.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TimeBasedKeyValueStore_981 {
    class TimeMap {

        class TimePair{
            private String value;
            private int timestamp;

            public TimePair(String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public int getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(int timestamp) {
                this.timestamp = timestamp;
            }
        }
        Map<String, LinkedList<TimePair>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (map.containsKey(key)){
                LinkedList<TimePair> val = map.get(key);
                val.add(0, new TimePair(value, timestamp));
                map.put(key, val);
            }else{
                TimePair timePair = new TimePair(value, timestamp);
                LinkedList<TimePair> val = new LinkedList<>();
                val.add(0, timePair);
                map.put(key, val);
            }
        }

        public String get(String key, int timestamp) {
            if(map.containsKey(key)){
                LinkedList<TimePair> val = map.get(key);
                for (int i = 0; i<val.size(); i++){
                    if (val.get(i).timestamp <= timestamp)
                        return val.get(i).value;
                }
            }
            return "";
        }
    }
}
