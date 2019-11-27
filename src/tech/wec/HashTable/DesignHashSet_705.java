package tech.wec.HashTable;

import java.util.ArrayList;
import java.util.List;

public class DesignHashSet_705 {
    class MyHashSet {
        List<Integer> list;
        /** Initialize your data structure here. */
        public MyHashSet() {
            list = new ArrayList<>();
        }

        public void add(int key) {
            if (list.contains(key)) return;
            list.add(key);
        }

        public void remove(int key) {
            if (!list.contains(key)) return;
            int idx = list.indexOf(key);
            list.remove(idx);
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return list.contains(key);
        }
    }
}
