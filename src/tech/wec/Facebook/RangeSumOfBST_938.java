package tech.wec.Facebook;

import tech.wec.Tree.TreeNode;

public class RangeSumOfBST_938 {

    private static int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    private void dfs(TreeNode root, int L, int R){
        if (root != null){
            if (L<=root.val&&root.val<=R)
                ans += root.val;
            if (L<root.val)
                dfs(root.left, L, R);
            if (root.val < R)
                dfs(root.right, L , R);
        }
    }
}
