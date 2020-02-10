package tech.wec.iLoveZQW;

public class CopyListWithRandomPointer_138 {
    class Solution {
        class Node {
            public int val;
            public Node next;
            public Node random;

            public Node() {}

            public Node(int _val,Node _next,Node _random) {
                val = _val;
                next = _next;
                random = _random;
            }
        };

        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node dummy = head;
            while(dummy != null){
                Node newNode = new Node(dummy.val, dummy.next, null);
                dummy.next = newNode;
                dummy = newNode.next;
            }
            dummy = head;
            while(dummy != null){
                dummy.next.random = dummy.random != null? dummy.random.next: null;
                dummy = dummy.next.next;
            }
            Node ptr_old = head;
            Node ptr_new = head.next;
            Node head_new = head.next;
            while(ptr_old != null){
                ptr_old.next = ptr_old.next.next;
                ptr_new.next = ptr_new.next != null? ptr_new.next.next: null;
                ptr_old = ptr_old.next;
                ptr_new = ptr_new.next;
            }
            return head_new;
        }
    }
}
