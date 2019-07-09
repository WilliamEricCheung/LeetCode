package tech.wec.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII_113 {
    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result.clear();
        path.clear();
        if (root == null)
            return result;
        path.add(root.val);
        findPath(root, sum);
        return result;
    }

    private void findPath(TreeNode root, int sum){
        // System.out.println(path);
        if (root == null)
            return;
        if (root.val == sum && root.left == null && root.right == null) {
            // System.out.println("find: "+ path);
            result.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null){
            path.add(root.left.val);
            findPath(root.left, sum - root.val);
            path.remove(path.size()-1);
        }
        if (root.right != null){
            path.add(root.right.val);
            findPath(root.right, sum - root.val);
            path.remove(path.size()-1);
        }
    }
}
