package tech.wec.HashTable;

import java.util.ArrayList;

public class DesignHashMap_706 {
    class MyHashMap {

        private class Entry{
            int key;
            int value;
            Entry next;
            Entry(int key, int value){
                this.key = key;
                this.value = value;
            }
            Entry(){
                this.key = -1;
            }
        }

        private ArrayList<Entry> map;

        /** Initialize your data structure here. */
        public MyHashMap() {
            map = new ArrayList<>();
            for (int i = 0;i<255;i++)
                map.add(new Entry());
        }

        private int hash(int key){
            return key % 255;
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hashedKey = hash(key);
            Entry entry = map.get(hashedKey);
            if (entry.key == -1){
                // empty entry, insert entry
                entry.key = key;
                entry.value = value;
            }else if (entry.key == key){
                // target entry
                entry.value = value;
            }else{
                // in list, find target entry
                while(entry.key != key && entry.next!=null){
                    entry = entry.next;
                }
                if (entry.key == key)
                    entry.value = value;
                else
                    entry.next = new Entry(key, value);
            }
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hashedKey = hash(key);
            Entry entry = map.get(hashedKey);
            if (entry.key == -1)
                return -1;
            else if (entry.key == key)
                return entry.value;
            else if (entry.next != null){
                while(entry.next!=null && entry.key != key){
                    entry = entry.next;
                }
                if (entry.key == key)
                    return entry.value;
                else
                    return -1;
            }else
                return -1;
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hashedKey = hash(key);
            Entry entry = map.get(hashedKey);
            if (entry.key == -1) {
                return;
            } else if (entry.key == key) {
                if (entry.next != null) map.set(hashedKey, entry.next);
                else entry.key = -1;
            } else if (entry.next != null) {
                Entry pre = entry, cur = entry.next;
                while (cur.next != null && cur.key != key) {
                    pre = cur;
                    cur = cur.next;
                }
                if (cur.key == key) {
                    pre.next = cur.next;
                }
            }
        }
    }
}


