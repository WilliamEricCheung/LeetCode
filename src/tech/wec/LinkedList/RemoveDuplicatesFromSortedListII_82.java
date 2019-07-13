package tech.wec.LinkedList;

public class RemoveDuplicatesFromSortedListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode l = new ListNode(Integer.MAX_VALUE);
        l.next = head;
        ListNode cur = l.next;
        ListNode curPast = l;
        head = head.next;
        while(head != null){
            if (cur.val == head.val){
                while(head != null && head.val == cur.val){
                    head = head.next;
                }
                cur = curPast;
                cur.next = head;
            }else{
                curPast = cur;
                cur = cur.next;
                curPast.next = cur;
                head = head.next;
            }
        }
        return l.next;
    }
}
