package tech.wec.LinkedList;

import java.util.List;

public class LinkedListCycleII_142 {
    public ListNode detectCycle(ListNode head) {
        ListNode p = getIntersectionNode(head);
        ListNode q = head;
        while(p!=null && p!=q){
            p = p.next;
            q = q.next;
        }
        return p;
    }

    private ListNode getIntersectionNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        if (head == null || head.next == null)
            return null;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return slow;
            }
        }
        return null;
    }
}
