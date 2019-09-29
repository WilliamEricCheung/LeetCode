package tech.wec.Google;

import tech.wec.Tree.TreeNode;

public class CountCompleteTreeNodes_222 {

    // transverse
    public int countNodes(TreeNode root) {
        return root != null ? 1 + countNodes(root.left) + countNodes(root.right) : 0;
    }

    // return tree depth in O(d) time
    public int computeDepth(TreeNode node){
        int d = 0;
        while(node.left != null){
            node = node.left;
            d++;
        }
        return d;
    }

    // last level nodes are enumerated from 0 to 2**d - 1 (left -> right)
    // return true if last level node idx exists
    // binary search with O(d) complexity
    public boolean exists(int idx, int d, TreeNode node){
        int left = 0, right = (int)Math.pow(2, d) - 1;
        int pivot;
        for (int i = 0; i < d; i++){
            pivot = left + (right - left) / 2;
            if (idx <= pivot){
                node = node.left;
                right = pivot;
            }else{
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }

    public int countNodes_1(TreeNode root){
        // if the tree is empty
        if (root == null) return 0;
        int d = computeDepth(root);
        // if the tree contains 1 node;
        if (d == 0) return 1;

        // last level nodes are enumerated from 0 to 2**d-1(left->right)
        // perform binary search to check how many nodes exist
        int left = 1, right = (int)Math.pow(2, d) - 1;
        int pivot;
        while(left <= right){
            pivot = left + (right - left) /2;
            if (exists(pivot, d, root))
                left = pivot + 1;
            else
                right = pivot - 1;
        }
        return (int)Math.pow(2,d)-1+left;
    }
}
