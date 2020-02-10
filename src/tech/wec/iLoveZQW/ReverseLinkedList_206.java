package tech.wec.iLoveZQW;

import java.util.Stack;

public class ReverseLinkedList_206 {

    class Solution {

        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while(cur != null){
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }
            return prev;
        }
    }
}
