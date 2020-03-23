package tech.wec.iLoveZQW;

import tech.wec.Tree.TreeNode;

public class SubtreeOfAnotherTree_572 {
    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            return transverse(s, t);
        }

        private boolean isEqual(TreeNode s, TreeNode t){
            if (s == null && t == null) return true;
            if (s == null || t == null) return false;
            return s.val == t.val && isEqual(s.left, t.left) && isEqual(s.right, t.right);
        }

        private boolean transverse(TreeNode s, TreeNode t){
            return s != null && (isEqual(s, t)|| transverse(s.left, t) || transverse(s.right, t));
        }
    }
}
