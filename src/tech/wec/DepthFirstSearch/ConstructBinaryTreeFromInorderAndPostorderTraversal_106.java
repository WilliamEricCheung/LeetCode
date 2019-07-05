package tech.wec.DepthFirstSearch;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return treeHelper(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode treeHelper(int[] postorder, int start1, int end1,
                               int[] inorder, int start2, int end2) {
        if (start2 > end2 || start1 > end1) return null;
        int root = start1;
        for (int i = start2; i <= end2; i++){
            if (inorder[i] == postorder[end1])
                root = i;
        }
        TreeNode left = treeHelper(postorder, start1, root-start2 + start1 -1,
                inorder, start2, root -1);
        TreeNode node = new TreeNode(postorder[end1]);
        node.left = left;
        node.right = treeHelper(postorder, root - start2 + start1, end1 - 1,
                inorder, root+1, end2);
        return node;
    }
}

