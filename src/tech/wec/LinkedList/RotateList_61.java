package tech.wec.LinkedList;

public class RotateList_61 {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode p = head, pre = null;
        int len = 0;
        while(p!=null){
            len++;
            p = p.next;
        }
        if (len == 0 || len ==1 || k % len == 0)
            return head;
        int pace = len - k % len;
        p = head;
        while(pace-- >0){
            pre = p;
            p = p.next;
        }
        pre.next = null;
        pre = p;
        while(pre.next!=null){
            pre = pre.next;
        }
        pre.next = head;
        return p;
    }
}
