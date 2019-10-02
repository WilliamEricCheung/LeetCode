package tech.wec.Facebook;

import tech.wec.Tree.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator_173 {
    class BSTIterator {

        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            leftMostInOrder(root);
        }

        private void leftMostInOrder(TreeNode root){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode topMost = stack.pop();
            if (topMost.right != null)
                this.leftMostInOrder(topMost.right);
            return topMost.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return stack.size() > 0;
        }
    }
}
