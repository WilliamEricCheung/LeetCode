package tech.wec.LinkedList;

public class RemoveNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = new ListNode(0);
        ListNode left = l;
        ListNode right = l;
        left.next = head;
        right.next = head;
        for (int i =0;i<=n;i++){
            right = right.next;
        }
        while(right != null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return l.next;
    }
}
