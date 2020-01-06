package tech.wec.DepthFirstSearch;

import tech.wec.LinkedList.ListNode;

public class ConvertSortedListToBinarySearchTree_109 {
    class Solution {
        private ListNode head;
        public TreeNode sortedListToBST(ListNode head) {
            this.head = head;
            return dfs(0, listSize(head) - 1);
        }

        // like in-order
        private TreeNode dfs(int left, int right){
            if (left > right) return null;
            int mid = left + (right - left) / 2;
            TreeNode leftNode = dfs(left, mid - 1);
            TreeNode node = new TreeNode(head.val);
            node.left = leftNode;
            head = head.next;
            TreeNode rightNode = dfs(mid + 1, right);
            node.right = rightNode;
            return node;
        }

        private int listSize(ListNode head){
            int size = 0;
            ListNode ptr = head;
            while(ptr != null){
                ptr = ptr.next;
                size++;
            }
            return size;
        }
    }
}
