package tech.wec.DepthFirstSearch;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return treeHelper(preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1);
    }

    public TreeNode treeHelper(int[] preorder, int start1, int end1,
                               int[] inorder, int start2, int end2) {
        if (start1 > end1) return null;
        // end recursive, return root node
        if (start1 == end1) return new TreeNode(preorder[start1]);
        int root = 0; // the location of root
        for (int i = start2; i <= end2; i++) {
            if (inorder[i] == preorder[start1])
                root = i;
        }
        TreeNode left = treeHelper(preorder, start1 + 1, start1 + root - start2,
                inorder, start2, root - 1);
        TreeNode right = treeHelper(preorder, start1 + root - start2 + 1, end1,
                inorder, root + 1, end2);
        TreeNode node = new TreeNode(preorder[start1]);
        node.left = left; node.right = right;
        return node;
    }
}
