package tech.wec.Facebook;

import tech.wec.Tree.TreeNode;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree_236 {

    // method 1: recursive
    private static TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root, p, q);
        return ans;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return false;
        int left = findNode(root.left, p, q) ? 1 : 0;
        int right = findNode(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (mid + left + right >= 2)
            ans = root;
        return (mid + left + right > 0);
    }

    // method 2: iterate using parent pointers
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q){
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();
            if (node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        // Ancestors set() for node p
        Set<TreeNode> ancestors = new HashSet<>();
        // Process all ancestors for node p using parent pointers.
        while(p!=null){
            ancestors.add(p);
            p = parent.get(p);
        }
        // The first ancestors of q which appears in
        // p's ancestor set() is their lowest common ancestor
        while(!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }
}
