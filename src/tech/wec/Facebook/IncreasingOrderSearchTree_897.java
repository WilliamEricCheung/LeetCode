package tech.wec.Facebook;

import tech.wec.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree_897 {

    private static List<Integer> vals;
    public TreeNode increasingBST(TreeNode root) {
        vals = new ArrayList<>();
        inorder(root);
        TreeNode ans = new TreeNode(0);
        TreeNode cur = ans;
        for (int val: vals){
            cur.right = new TreeNode(val);
            cur = cur.right;
        }
        return ans.right;
    }

    private void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        vals.add(root.val);
        inorder(root.right);
    }
}
