package tech.wec.LinkedList;

public class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) { val = x; }

      public static String listNodeToString(ListNode node) {
            if (node == null) {
                  return "[]";
            }

            String result = "";
            while (node != null) {
                  result += Integer.toString(node.val) + ", ";
                  node = node.next;
            }
            return "[" + result.substring(0, result.length() - 2) + "]";
      }
}
