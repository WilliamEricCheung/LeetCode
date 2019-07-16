package tech.wec.Tree;

public class BalancedBinaryTree_110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = depth(root.left);
        int right = depth(root.right);
        int diff = Math.abs(left-right);
        if (diff > 1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root){
        if (root == null)
            return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if (left > 0 && right > 0)
            return 1+Math.max(left, right);
        else
            return 1+left+right;
    }
}
