package tech.wec.Brainteaser;

import tech.wec.Tree.TreeNode;

public class SumOfLeftLeaves_404 {

    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        bst(root, true);
        return ans;
    }

    private void bst(TreeNode root, boolean skip){
        if (root == null) return;
        else if (root.left == null && root.right == null && skip == false)
            ans += root.val;
        else{
            bst(root.left, false);
            bst(root.right, true);
        }
    }
}
