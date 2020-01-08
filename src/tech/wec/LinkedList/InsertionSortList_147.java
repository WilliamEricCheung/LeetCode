package tech.wec.LinkedList;

public class InsertionSortList_147 {
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null) return null;
            ListNode ptr = head.next;
            ListNode cur;
            while(ptr != null){
                cur = head;
                while(ptr != null && ptr != cur && ptr.val > cur.val)
                    cur = cur.next;
                while(ptr != null && ptr != cur && ptr.val <= cur.val){
                    int val = cur.val;
                    cur.val = ptr.val;
                    ptr.val = val;
                    cur = cur.next;
                }
                ptr = ptr.next;
            }
            return head;
        }
    }
}
