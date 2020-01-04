package tech.wec.Tree;

public class LongestUnivaluePath_687 {
    class Solution {

        private int max;
        public int longestUnivaluePath(TreeNode root) {
            max = 0;
            helper(root);
            return max;
        }

        private int helper(TreeNode node){
            if (node == null) return 0;
            int left = helper(node.left);
            int right = helper(node.right);
            int l = 0, r = 0;
            if (node.left != null && node.val == node.left.val) l += left + 1;
            if (node.right != null && node.val == node.right.val) r += right + 1;
            max = Math.max(max, l + r);
            return Math.max(l, r);
        }
    }
}
