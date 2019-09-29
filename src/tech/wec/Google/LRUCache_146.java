package tech.wec.Google;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_146 {

    class LRUCache {

        class DLinkedNode{
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        private void addNode(DLinkedNode node){
            // always add the new node right after head
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node){
            // remove ann existing node from the linked list
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(DLinkedNode node){
            removeNode(node);
            addNode(node);
        }

        private DLinkedNode popTail(){
            // pop the current tail
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null)
                return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null){
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                cache.put(key, newNode);
                addNode(newNode);

                size++;

                if (size > capacity){
                    // pop the tail
                    DLinkedNode tail = popTail();
                    cache.remove(tail.key);
                    size--;
                }
            }else{
                // update the value
                node.value = value;
                moveToHead(node);
            }
        }
    }


    class LRUCache_1 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache_1(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
