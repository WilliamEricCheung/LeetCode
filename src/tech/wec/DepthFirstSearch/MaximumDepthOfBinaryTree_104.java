package tech.wec.DepthFirstSearch;

public class MaximumDepthOfBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        return curDepth(root, 0);
    }

    public int curDepth(TreeNode cur, int depth) {
        if (cur == null) {
            return depth;
        } else if (cur.right == null && cur.left == null) {
            return depth + 1;
        } else {
            return Math.max(curDepth(cur.left, depth + 1), curDepth(cur.right, depth + 1));
        }
    }
}
