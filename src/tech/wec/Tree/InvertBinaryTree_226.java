package tech.wec.Tree;

public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        // 只要两边存在元素就要反转
        if (!(root.left == null && root.right == null)) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.right = left;
            root.left = right;
            if (root.right != null)
                invertTree(root.right);
            if (root.left != null)
                invertTree(root.left);
        }
        return root;
    }
}
