package tech.wec.LinkedList;

public class ParititionList_86 {
    public static void main(String[] args) {
         Solution solution = new Solution();
         ListNode head = new ListNode(2); head.next = new ListNode(1);
         head = solution.partition(head, 2);
         solution.printNodes(head);
    }
    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummy = new ListNode(0);
            ListNode dummyPtr = dummy;
            ListNode origin = new ListNode(0);
            ListNode originPtr = origin;
            while(head != null){
                if (head.val >= x){
                    dummyPtr.next = head;
                    dummyPtr = dummyPtr.next;
                }else{
                    originPtr.next = head;
                    originPtr = originPtr.next;
                }
                head = head.next;
            }
            dummyPtr.next = null;
            originPtr.next = dummy.next;
            return origin.next;
        }

        public void printNodes(ListNode head){
            while(head != null){
                System.out.println(head.val);
                head = head.next;
            }
        }
    }
}
