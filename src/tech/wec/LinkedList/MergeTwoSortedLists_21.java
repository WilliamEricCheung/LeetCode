package tech.wec.LinkedList;

public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode p = l1, q = l2;
            ListNode cur = new ListNode(0);
            ListNode res = cur;
            while (p != null && q != null) {
                if (p.val <= q.val) {
                    cur.next = new ListNode(p.val);
                    p = p.next;
                    cur = cur.next;
                } else {
                    cur.next = new ListNode(q.val);
                    q = q.next;
                    cur = cur.next;
                }
            }
            if (p == null) {
                cur.next = q;
            } else {
                cur.next = p;
            }
            return res.next;
        }
}
