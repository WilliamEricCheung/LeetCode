package tech.wec.iLoveZQW;

import tech.wec.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree_366 {
    class Solution {

        private List<List<Integer>> list;

        public List<List<Integer>> findLeaves(TreeNode root) {
            this.list = new ArrayList<>();
            while(root != null){
                List<Integer> leaves = new ArrayList<>();
                root = dfs(root, leaves);
                list.add(leaves);
            }
            return list;
        }

        private TreeNode dfs(TreeNode node, List<Integer> leaves){
            if (node == null) return null;
            if (node.left == null && node.right == null){
                leaves.add(node.val);
                return null;
            }
            node.left = dfs(node.left, leaves);
            node.right = dfs(node.right, leaves);
            return node;
        }
    }
}
