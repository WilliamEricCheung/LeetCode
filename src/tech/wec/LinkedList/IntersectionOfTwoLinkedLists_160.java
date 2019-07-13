package tech.wec.LinkedList;

public class IntersectionOfTwoLinkedLists_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if(lenA > lenB){
            for(int i = 0; i < lenA - lenB; i++){
                headA = headA.next;
            }
        }
        else{
            for(int i = 0; i < lenB - lenA; i++){
                headB = headB.next;
            }
        }
        while(headA != null && headB != null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return (headA != null && headB != null)? headA : null;
    }

    public int getLength(ListNode head){
        int index = 0;
        while(head != null){
            index++;
            head = head.next;
        }
        return index;
    }
}
