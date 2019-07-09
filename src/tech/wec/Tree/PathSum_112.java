package tech.wec.Tree;

public class PathSum_112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && root.left == null && root.right == null)
            return true;
        else if (root.left == null && root.right == null)
            return false;
        else
            return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum - root.val);
    }
}
