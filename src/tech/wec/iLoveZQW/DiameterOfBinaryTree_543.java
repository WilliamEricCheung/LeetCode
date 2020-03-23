package tech.wec.iLoveZQW;

import tech.wec.Tree.TreeNode;

public class DiameterOfBinaryTree_543 {
    class Solution {
        int ans;
        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }

        private int depth(TreeNode root){
            if (root == null) return 0;
            int left = depth(root.left);
            int right = depth(root.right);
            ans = Math.max(ans, left + right + 1);
            return Math.max(left, right) + 1;
        }
    }
}
