package tech.wec.iLoveZQW;

import java.util.List;

public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode ptr = ans;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                ptr.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                ptr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        if (l1 != null) ptr.next = l1;
        if (l2 != null) ptr.next = l2;
        return ans.next;
    }
}
