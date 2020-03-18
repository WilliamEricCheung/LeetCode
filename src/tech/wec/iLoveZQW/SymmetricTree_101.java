package tech.wec.iLoveZQW;

import tech.wec.Tree.TreeNode;

public class SymmetricTree_101 {

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return symmetric(root, root);
        }

        private boolean symmetric(TreeNode p, TreeNode q){
            return (p == null && q == null) || ((p != null && q != null) && ((p.val == q.val) && (symmetric(p.left, q.right) && symmetric(p.right, q.left))));
        }
    }
}
