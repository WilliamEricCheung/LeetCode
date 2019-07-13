package tech.wec.LinkedList;

public class RemoveLinkedListElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode l = new ListNode(0);
        ListNode res = l;
        while(head!=null){
            if (head.val != val){
                l.next = new ListNode(head.val);
                l = l.next;
            }
            head = head.next;
        }
        return res.next;
    }
}
