package tech.wec.iLoveZQW;

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode ptr = ans;
        int remain = 0;
        while(l1 != null || l2 != null){
            if (l1 != null && l2 != null){
                int add = l1.val + l2.val + remain;
                ptr.next = new ListNode(add % 10);
                remain = add / 10;
                ptr = ptr.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l1 != null && l2 == null){
                int add = l1.val + remain;
                ptr.next = new ListNode(add % 10);
                remain = add / 10;
                ptr = ptr.next;
                l1 = l1.next;
            }
            else if (l1 == null && l2 != null){
                int add = l2.val + remain;
                ptr.next = new ListNode(add % 10);
                remain = add / 10;
                ptr = ptr.next;
                l2 = l2.next;
            }
        }
        if (remain != 0) {
            ptr.next = new ListNode(remain);
            ptr = ptr.next;
        }
        return ans.next;
    }
}
