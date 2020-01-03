package tech.wec.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
    class Solution {
        private List<Integer> result;
        public List<Integer> postorderTraversal(TreeNode root) {
            result = new ArrayList<>();
            postorder(root);
            return result;
        }

        private void postorder(TreeNode node){
            if (node == null) return;
            if (node.left != null) postorder(node.left);
            if (node.right != null) postorder(node.right);
            result.add(node.val);
        }
    }
}
