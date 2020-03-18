package tech.wec.iLoveZQW;

import tech.wec.Tree.TreeNode;

public class SameTree_100 {
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return (p == null && q == null) || ((p != null && q != null) && ((p.val == q.val) && (isSameTree(p.left, q.left) && isSameTree(p.right, q.right))));
        }
    }
}
