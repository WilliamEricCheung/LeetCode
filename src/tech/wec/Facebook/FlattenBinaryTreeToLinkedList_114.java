package tech.wec.Facebook;

import tech.wec.Tree.TreeNode;

public class FlattenBinaryTreeToLinkedList_114 {
    // iterate
    public void flatten_1(TreeNode root) {
        TreeNode node = root;
        while(node != null){
            if (node.left != null){
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = null;
                TreeNode ptr = node.right;
                while(ptr.right != null)
                    ptr = ptr.right;
                ptr.right = tmp;
            }
            node = node.right;
        }
    }

    // recursive
    public void flatten(TreeNode root){
        if (root == null) return;
        if (root.left != null) flatten(root.left);
        if (root.right != null) flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null)
            root = root.right;
        root.right = tmp;
    }
}
