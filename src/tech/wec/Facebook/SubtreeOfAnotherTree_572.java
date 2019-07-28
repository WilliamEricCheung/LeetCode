package tech.wec.Facebook;

import tech.wec.Tree.TreeNode;

public class SubtreeOfAnotherTree_572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    private boolean equal(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val && equal(s.left, t.left) && equal(s.right, t.right);
    }

    private boolean traverse(TreeNode s, TreeNode t){
        return s != null && (equal(s, t) || traverse(s.left ,t) || traverse(s.right, t));
    }
}
