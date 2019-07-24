package tech.wec.Facebook;

import tech.wec.LinkedList.ListNode;

import java.util.Stack;

public class ReverseNodesInKGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head, tmp, prev = null;
        int cnt = 0;
        while(ptr != null && cnt < k){
            tmp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = tmp;
            cnt++;
        }
        if (cnt == k)
            head.next = reverseKGroup(ptr, k);
        else if (cnt < k && cnt > 0)
            return reverseKGroup(prev, cnt);
        return prev;
    }
}
