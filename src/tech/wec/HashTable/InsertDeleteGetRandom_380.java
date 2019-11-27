package tech.wec.HashTable;


import java.util.*;

public class InsertDeleteGetRandom_380 {
    class RandomizedSet {

        private Map<Integer, Integer> set;
        private List<Integer> list;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            set = new HashMap<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (set.containsKey(val)) return false;
            set.put(val, set.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!set.containsKey(val)) return false;
            int lastElement = list.get(list.size() - 1);
            int idx = set.get(val);
            list.set(idx, lastElement);
            set.put(lastElement, idx);
            list.remove(list.size() - 1);
            set.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }
    }
}
