package tech.wec.Facebook;

import tech.wec.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class LeafSimilarTrees_872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> root1Leaves = DFS(root1);
        ArrayList<Integer> root2Leaves = DFS(root2);

        if (root1Leaves.size() != root2Leaves.size())
            return false;
        int size = root1Leaves.size();
        for (int i = 0; i < size; i++) {
            if (!root1Leaves.get(i).equals(root2Leaves.get(i)))
                return false;
        }
        return true;
    }

    class Node {
        int val;
        boolean isLeaf;
    }

    public ArrayList<Integer> DFS(TreeNode root) {
        ArrayList<Node> list = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // 先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            if (node.left == null && node.right == null) {
                Node tmp = new Node();
                tmp.val = node.val;
                tmp.isLeaf = true;
                list.add(tmp);
            } else {
                Node tmp = new Node();
                tmp.val = node.val;
                tmp.isLeaf = false;
                list.add(tmp);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isLeaf) {
                res.add(list.get(i).val);
            }
        }
        return res;
    }
}
