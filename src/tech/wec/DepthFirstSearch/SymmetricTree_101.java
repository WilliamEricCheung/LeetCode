package tech.wec.DepthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_101 {
    // recursive
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }

    public boolean symmetric(TreeNode left, TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return (left.val == right.val) && symmetric(left.left, right.right)
                && symmetric(left.right, right.left);
    }

    // iterate
    public boolean isSymmetric_1(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1==null && t2== null)
                continue;
            if (t1==null || t2==null)
                return false;
            if (t1.val != t2.val)
                return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}
