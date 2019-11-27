package tech.wec.Tree;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIV_653 {

    private List<Integer> list;
    public boolean findTarget(TreeNode root, int k) {
        list = new ArrayList<>();
        inorder(root); // 中序访问的BST结果为排好顺序的数组
        int left = 0, right = list.size() - 1;
        while(left < right){
            if (list.get(left) + list.get(right) > k)
                right--;
            else if (list.get(left) + list.get(right) < k)
                left++;
            else
                return true;
        }
        return false;
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
