package tech.wec.LinkedList;

import java.util.Stack;

public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode tail = reverseList(head);
        ListNode head1 = head;
        ListNode tail1 = tail;
        while (head1 != null && tail1 != null) {
            if (head1.val == tail1.val) {
                head1 = head1.next;
                tail1 = tail1.next;
            } else {
                return false;
            }
        }
        return true;
    }
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        ListNode res = new ListNode(0);
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = res;
        System.out.println(stack);
        while (!stack.isEmpty()) {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }
        return res.next;
    }
}
