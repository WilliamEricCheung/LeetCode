package tech.wec.BinarySearch;

import tech.wec.Tree.TreeNode;

public class ClosestBinarySearchTreeValue_270 {
    public int closestValue(TreeNode root, double target) {
        int ans = root.val;
        while(root != null){
            int val = root.val;
            ans = Math.abs(val - target) < Math.abs(ans - target)? val: ans;
            root = target < root.val? root.left: root.right;
        }
        return ans;
    }
}
