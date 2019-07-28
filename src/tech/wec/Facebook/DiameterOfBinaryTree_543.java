package tech.wec.Facebook;

import tech.wec.Tree.TreeNode;

public class DiameterOfBinaryTree_543 {

    private static int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        dfs(root);
        return ans - 1;
    }

    private int dfs(TreeNode root){
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
