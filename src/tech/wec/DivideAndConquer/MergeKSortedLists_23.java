package tech.wec.DivideAndConquer;

import tech.wec.LinkedList.ListNode;

public class MergeKSortedLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        int listNum = lists.length;
        if (listNum == 0)
            return null;
        int interval = 1;
        while(interval < listNum){
            for (int i =0;i+interval < listNum;i += interval * 2)
                lists[i] = mergeTwoLists(lists[i], lists[i+interval]);
            interval *= 2;
        }
        return lists[0];
    }

    // use problem 21 method to merge two lists
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
