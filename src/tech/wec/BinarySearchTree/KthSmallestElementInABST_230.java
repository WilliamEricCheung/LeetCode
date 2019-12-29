package tech.wec.BinarySearchTree;

import tech.wec.Tree.TreeNode;

import java.util.LinkedList;

public class KthSmallestElementInABST_230 {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(true){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
