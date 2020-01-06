package tech.wec.LinkedList;

import java.util.Stack;

public class ReorderList_143 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        solution.reorderList(head);
        System.out.println(head.val);
    }
    static class Solution {
        // 1. 先把链表L倒置一个临时列表L'
        // 2. L和L'按顺序合并直到到L的长度
        // 也可以用快慢指针来索引，更快
        private int length;
        public void reorderList(ListNode head) {
            if (head == null) return;
            length = 0;
            ListNode head1 = new ListNode(-1);
            head1 = reverseList(head);
            ListNode result = new ListNode(-1);
            ListNode headPtr = head;
            ListNode ptr = result;
            int cnt = 0;
            while(cnt < length){
                // add L
                ptr.next = new ListNode(headPtr.val);
                ptr = ptr.next;
                headPtr = headPtr.next;
                cnt++;
                // add L', before that we should consist cnt <= length
                if (cnt < length){
                    ptr.next = new ListNode(head1.val);
                    ptr = ptr.next;
                    head1 = head1.next;
                    cnt++;
                }
            }
            // head = result.next; 错误用法，java对象引用类型，只是改变了副本
            while(result.next != null){
                head.val = result.next.val;
                head = head.next;
                result = result.next;
            }

        }
        // 直接引用lc206的链表倒装
        public ListNode reverseList(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            ListNode cur = head;
            ListNode res = new ListNode(0);
            while (cur != null) {
                stack.push(cur.val);
                cur = cur.next;
            }
            cur = res;
            length = stack.size(); // 多了一行链表的长度
            // System.out.println(stack);
            while (!stack.isEmpty()) {
                cur.next = new ListNode(stack.pop());
                cur = cur.next;
            }
            return res.next;
        }
    }
}
