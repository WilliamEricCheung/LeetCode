package tech.wec.iLoveZQW;

import tech.wec.Tree.TreeNode;

public class ConvertSortedListToBinarySearchTree_109 {
    class Solution {
        private ListNode head;
        public TreeNode sortedListToBST(ListNode head) {
            this.head = head;
            return buildTree(0, listLength(head) - 1);
        }

        private TreeNode buildTree(int left, int right){
            if (left > right) return null;
            int mid = left + (right - left) / 2;
            TreeNode leftTree = buildTree(left, mid - 1);
            TreeNode root = new TreeNode(head.val);
            root.left = leftTree;
            head = head.next;
            TreeNode rightTree = buildTree(mid + 1, right);
            root.right = rightTree;
            return root;
        }

        private int listLength(ListNode head){
            int length = 0;
            while (head != null){
                length++;
                head = head.next;
            }
            return length;
        }
    }
}
