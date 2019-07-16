package tech.wec.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_107 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return res;
        else {
            DFS(root, 0);
            Collections.reverse(res);
            return res;
        }
    }

    void DFS(TreeNode root, int level) {
        int size = res.size();
        // run into next
        if (level > size - 1)
            res.add(new ArrayList<>());
        res.get(level).add(root.val);
        if (root.left != null) {
            DFS(root.left, level + 1);
        }
        if (root.right != null) {
            DFS(root.right, level + 1);
        }
    }
}
