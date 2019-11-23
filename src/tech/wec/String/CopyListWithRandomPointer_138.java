package tech.wec.String;

public class CopyListWithRandomPointer_138 {
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

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node ptr = head;
            while(ptr != null){
                // Inserting the cloned node just next to the original node.
                // If A->B->C is the original linked list,
                // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
                Node newNode = new Node(ptr.val, ptr.next, null);
                ptr.next = newNode;
                ptr = newNode.next;
            }
            ptr = head;
            while(ptr != null){
                ptr.next.random = (ptr.random != null)? ptr.random.next: null;
                ptr = ptr.next.next;
            }

            // unweave
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
