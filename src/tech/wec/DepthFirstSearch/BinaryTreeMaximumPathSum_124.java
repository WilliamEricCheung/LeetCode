package tech.wec.DepthFirstSearch;

public class BinaryTreeMaximumPathSum_124 {
    class Solution {

        private int maxSum;

        public int maxPathSum(TreeNode root) {
            maxSum = Integer.MIN_VALUE;
            pathSum(root);
            return maxSum;
        }

        private int pathSum(TreeNode node){
            if (node == null) return 0;
            int left = Math.max(pathSum(node.left), 0);
            int right = Math.max(pathSum(node.right), 0);
            int newPath = node.val + left + right;
            maxSum = Math.max(maxSum, newPath);
            return node.val + Math.max(left, right);
        }
    }
}
