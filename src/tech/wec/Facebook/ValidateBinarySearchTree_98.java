package tech.wec.Facebook;

import tech.wec.Tree.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper){
        if (node == null) return true;
        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!helper(node.right, val, upper)) return false;
        if (!helper(node.left, lower, val)) return false;
        return true;
    }
    // inorder traversal
    public boolean isValidBST_1(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        double inorder = - Double.MAX_VALUE;
        while(!stack.empty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder)
                return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
