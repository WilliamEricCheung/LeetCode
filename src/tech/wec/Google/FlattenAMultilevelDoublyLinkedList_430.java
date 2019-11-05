package tech.wec.Google;

public class FlattenAMultilevelDoublyLinkedList_430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };

    class Solution {
        // recursive
        public Node flatten(Node head) {
            if (head == null || (head.next == null && head.child == null)) return head;
            Node ptr = head;
            while(ptr != null){
                if (ptr.child != null){
                    Node next = ptr.next;
                    ptr.next = flatten(ptr.child);
                    ptr.child = null;
                    ptr.next.prev = ptr;
                    // 移动到原child末尾
                    while(ptr.next != null)
                        ptr = ptr.next;
                    // 接上原next
                    ptr.next = next;
                    if (next != null)
                        next.prev = ptr;
                }
                ptr = ptr.next;
            }
            return head;
        }
    }
}
