package tech.wec.Facebook;

import tech.wec.LinkedList.ListNode;

import static tech.wec.LinkedList.ListNode.listNodeToString;

public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode ptr = head;
        ListNode prev = new ListNode(0);
        prev.next = ptr;
        ListNode result = new ListNode(0);
        ListNode resPtr = result;
        while(ptr != null && ptr.next != null){
            prev.next = ptr.next;
            ptr.next = ptr.next.next;
            prev.next.next = ptr;
            resPtr.next = prev.next;
            resPtr.next.next = prev.next.next;
            resPtr = resPtr.next.next;
            //System.out.println(listNodeToString(result));
            //System.out.println(listNodeToString(prev));
            //System.out.println(listNodeToString(ptr));
            if (ptr == null || ptr.next == null || ptr.next.next == null)
                break;
            else{
                prev.next = ptr.next;
                ptr = ptr.next;
            }
        }
        return result.next;
    }
}
