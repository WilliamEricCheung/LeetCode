package tech.wec.DepthFirstSearch;

import java.util.*;

public class FindLeavesOfBinaryTree_366 {
    class Solution {

        private List<List<Integer>> result;

        public List<List<Integer>> findLeaves(TreeNode root) {
            result = new ArrayList<>();
            while(root != null){
                List<Integer> list = new ArrayList<>();
                root = dfs(root, list);
                result.add(list);
            }
            return result;
        }

        private TreeNode dfs(TreeNode node, List<Integer> list){
            if (node == null) return null;
            if (node.left == null && node.right == null){
                list.add(node.val);
                return null;
            }
            node.left = dfs(node.left, list);
            node.right = dfs(node.right, list);
            return node;
        }
    }
}
