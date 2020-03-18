package tech.wec.iLoveZQW;

import tech.wec.Tree.TreeNode;

public class MaximumDepthOfBinaryTree_104 {
    class Solution {
        public int maxDepth(TreeNode root) {
            return depth(root, 0);
        }

        private int depth(TreeNode root, int depth){
            if (root == null) return depth;
            return Math.max(depth(root.left, depth + 1), depth(root.right, depth + 1));
        }
    }
}
