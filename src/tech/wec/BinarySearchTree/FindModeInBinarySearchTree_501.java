package tech.wec.BinarySearchTree;

import tech.wec.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree_501 {

    Integer prev = null;
    int cnt = 1;
    int max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans.stream().mapToInt(i->i).toArray();
    }

    private void inorder(TreeNode root, List<Integer> ans){
        if (root == null) return;
        inorder(root.left, ans);
        if (prev != null){
            if (prev == root.val)
                cnt++;
            else
                cnt = 1;
        }
        if (cnt > max){
            max = cnt;
            ans.clear();
            ans.add(root.val);
        }
        else if (cnt == max){
            ans.add(root.val);
        }
        prev = root.val;
        inorder(root.right, ans);
    }
}
