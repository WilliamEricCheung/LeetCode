package tech.wec.LinkedList;

public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // split list
        ListNode[] split = devide(head);
        // then merge them
        ListNode left = sortList(split[0]);
        ListNode right = sortList(split[1]);
        // recursive function
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right){
        if (left == null)
            return right;
        if (right == null)
            return left;
        if (left.val < right.val){
            left.next = merge(left.next, right);
            return left;
        }
        right.next = merge(left, right.next);
        return right;
    }

    private ListNode[] devide(ListNode node){
        ListNode[] ret = new ListNode[2];
        ListNode left = node;
        ListNode right = node;
        ListNode splitPoint = null;
        while(right != null && right.next != null){
            splitPoint = left;
            left = left.next;
            right = right.next.next;
        }
        if (splitPoint != null)
            splitPoint.next = null;
        ret[1] = left;
        ret[0] = node;
        return ret;
    }
}
