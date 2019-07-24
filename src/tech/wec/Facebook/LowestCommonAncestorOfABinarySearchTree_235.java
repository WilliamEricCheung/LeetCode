package tech.wec.Facebook;

import tech.wec.Tree.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree_235 {

    // recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (pVal > rootVal && qVal > rootVal)
            return lowestCommonAncestor(root.right, p, q);
        else if (pVal < rootVal && qVal < rootVal)
            return lowestCommonAncestor(root.left, p, q);
        else
            return root;
    }
    // iterate
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q){
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (node != null){
            int nodeVal = node.val;
            if (pVal > nodeVal && qVal > nodeVal)
                node = node.right;
            else if (pVal < nodeVal && qVal < nodeVal)
                node = node.left;
            else
                return node;
        }
        return null;
    }
}
