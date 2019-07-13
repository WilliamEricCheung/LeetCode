package tech.wec.LinkedList;

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode ret = l;
        int add = 0;
        while(l1 != null || l2!= null){
            l.next = new ListNode(0);
            if (l1 != null && l2 != null){
                int tmp = l1.val + l2.val + add;
                if (tmp >= 10){
                    l.next.val = tmp % 10;
                    add = tmp / 10;
                }else{
                    l.next.val = tmp;
                    add = 0;
                }
                l = l.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l1 == null && l2 != null){
                int tmp = add + l2.val;
                if (tmp >= 10){
                    l.next.val = tmp % 10;
                    add = tmp / 10;
                }else {
                    l.next.val = tmp;
                    add = 0;
                }
                l = l.next;
                l2 = l2.next;
            }
            else if (l1 != null && l2 == null){
                int tmp = add + l1.val;
                if (tmp >= 10){
                    l.next.val = tmp % 10;
                    add = tmp / 10;
                }else {
                    l.next.val = tmp;
                    add = 0;
                }
                l = l.next;
                l1 = l1.next;
            }
            if (add != 0){
                l.next = new ListNode(add);
            }
        }
        return ret.next;
    }
}
