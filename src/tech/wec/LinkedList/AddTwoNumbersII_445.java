package tech.wec.LinkedList;

public class AddTwoNumbersII_445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = addZeroHead(l1);
        l2 = addZeroHead(l2);

        for (ListNode cur1 = l1, cur2 = l2; cur1!=null || cur2 !=null;){
            if (cur1 == null)
                l1 = addZeroHead(l1);
            else if (cur2 == null)
                l2 = addZeroHead(l2);
            if (cur1 !=null)
                cur1 = cur1.next;
            if (cur2 != null)
                cur2 = cur2.next;
        }

        ListNode ans = recursiveAdd(l1, l2);
        if (ans.val == 0 && ans.next != null)
            ans = ans.next;
        return ans;
    }

    private ListNode addZeroHead(ListNode node){
        ListNode newNode = new ListNode(0);
        newNode.next = node;
        return newNode;
    }

    private ListNode recursiveAdd(ListNode l1, ListNode l2){
        if (l1 == null)
            return null;
        ListNode next = recursiveAdd(l1.next, l2.next);
        int carry = 0;
        if (next != null && next.val >= 10){
            carry = next.val / 10;
            next.val = next.val % 10;
        }

        int sum = l1.val + l2.val + carry;
        ListNode cur = new ListNode(sum);
        cur.next = next;
        return cur;
    }
}
