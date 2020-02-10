package tech.wec.iLoveZQW;

public class MergeKSortedLists_23 {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0 || lists == null) return null;
            int n = lists.length;
            int val = 1;
            while (val < n){
                for (int i = 0; i + val < n; i += 2 * val) {
                    lists[i] = mergeTwoLists(lists[i], lists[i + val]);
                }
                val = val * 2;
            }
            return lists[0];
        }

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
}
