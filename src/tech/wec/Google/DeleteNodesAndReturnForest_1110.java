package tech.wec.Google;

import tech.wec.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodesAndReturnForest_1110 {
    List<TreeNode> result;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete){
        result = new ArrayList<>();
        boolean[] visited = new boolean[1001];
        for (int i : to_delete)
            visited[i] = true;
        bfs(root, null, visited);
        return result;
    }

    private void bfs(TreeNode node, TreeNode parent, boolean[] visited){
        if (node == null) return;
        if (visited[node.val]){
            updateParent(node, parent);
            bfs(node.left, null, visited);
            bfs(node.right, null, visited);
        }
        else{
            if (parent == null)
                result.add(node);
            bfs(node.left, node, visited);
            bfs(node.right, node, visited);
        }
    }

    private void updateParent(TreeNode node, TreeNode parent){
        if (parent != null) {
            if (parent.left == node)
                parent.left = null;
            else
                parent.right = null;
        }
    }
}
