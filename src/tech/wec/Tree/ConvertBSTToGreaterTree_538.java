package tech.wec.Tree;

public class ConvertBSTToGreaterTree_538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
