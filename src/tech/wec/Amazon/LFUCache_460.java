package tech.wec.Amazon;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache_460 {
    class LFUCache{
        private int leastFrequency;
        private int capacity;
        private Map<Integer, Node> keyNodeMap;
        private Map<Integer, LinkedHashSet<Integer>> freqKeyMap; // LRU

        public LFUCache(int capacity){
            this.leastFrequency = 1;
            this.capacity = capacity;
            this.keyNodeMap = new HashMap<>();
            this.freqKeyMap = new HashMap<>();
        }

        public int get(int key){
            if (!keyNodeMap.containsKey(key)) return -1;
            update(key, keyNodeMap.get(key));
            return keyNodeMap.get(key).value;
        }

        private void update(int key, Node updateNode){
            int nodeFreq = updateNode.freq;
            freqKeyMap.get(nodeFreq).remove(key);
            if (nodeFreq == leastFrequency && freqKeyMap.get(nodeFreq).size() == 0) leastFrequency++;
            updateNode.freq++;
            keyNodeMap.put(key, updateNode);
            freqKeyMap.computeIfAbsent(nodeFreq + 1, ignore -> new LinkedHashSet<>());
            freqKeyMap.get(nodeFreq + 1).add(key);
        }

        public void put(int key, int value){
            if (keyNodeMap.containsKey(key)){
                Node node = keyNodeMap.get(key);
                node.value = value;
                update(key, node);
            }else{
                keyNodeMap.put(key, new Node(value, 1));
                freqKeyMap.computeIfAbsent(1, ignore -> new LinkedHashSet<>());
                freqKeyMap.get(1).add(key);
                if (this.capacity == 0){
                    int removedKey = freqKeyMap.get(leastFrequency).iterator().next();
                    freqKeyMap.get(leastFrequency).remove(removedKey);
                    keyNodeMap.remove(removedKey);
                }else this.capacity--;
                leastFrequency = 1;
            }
        }
    }

    class Node{
        public int freq;
        public int value;
        public Node(int value, int freq){
            this.value = value;
            this.freq = freq;
        }
    }
}
