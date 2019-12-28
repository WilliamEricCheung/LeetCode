package tech.wec.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    class Solution {
        List<Integer> list;
        public List<Integer> preorderTraversal(TreeNode root) {
            list = new ArrayList<>();
            preorder(root);
            return list;
        }

        private void preorder(TreeNode node){
            if (node == null) return;
            list.add(node.val);
            if (node.left != null) preorder(node.left);
            if (node.right != null) preorder(node.right);
        }
    }
}
