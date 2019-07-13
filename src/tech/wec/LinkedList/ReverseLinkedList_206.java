package tech.wec.LinkedList;

import java.util.Stack;

public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        ListNode res = new ListNode(0);
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = res;
        // System.out.println(stack);
        while (!stack.isEmpty()) {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }
        return res.next;
    }
}
