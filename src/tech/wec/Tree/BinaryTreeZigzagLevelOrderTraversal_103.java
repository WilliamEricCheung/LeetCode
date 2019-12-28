package tech.wec.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    // dfs
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        dfs(root, 0, results);
        return results;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> results){
        if (level >= results.size()){
            LinkedList<Integer> newLevel = new LinkedList<>();
            newLevel.add(node.val);
            results.add(newLevel);
        }else{
            if (level % 2 == 0) results.get(level).add(node.val); // add to the tail
            else results.get(level).add(0, node.val); // add to the head
        }
        if (node.left != null) dfs(node.left, level + 1, results);
        if (node.right != null) dfs(node.right, level + 1, results);
    }
}
