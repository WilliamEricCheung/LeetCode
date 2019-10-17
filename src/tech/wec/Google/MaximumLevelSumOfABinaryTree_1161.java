package tech.wec.Google;

import tech.wec.Tree.TreeNode;

public class MaximumLevelSumOfABinaryTree_1161 {

    int[] levelSum = new int[10000];
    public int maxLevelSum(TreeNode root){
        inorder(root, 1);
        int ans = 0;
        for (int i = 0; i < 10000;i++)
            ans = levelSum[i] > levelSum[ans]? i: ans;
        return ans;
    }

    private void inorder(TreeNode node, int level){
        if (node != null){
            inorder(node.left, level + 1);
            levelSum[level] += node.val;
            inorder(node.right, level + 1);
        }
    }
}
