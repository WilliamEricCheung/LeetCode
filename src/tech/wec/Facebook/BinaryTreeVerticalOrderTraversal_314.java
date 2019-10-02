package tech.wec.Facebook;

import tech.wec.String.LicenseKeyFormatting_482;
import tech.wec.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal_314 {

    public int[] getRange(TreeNode node, int level){
        int[] output = {level, level};
        if (node.right != null){
            int[] res = getRange(node.right, level + 1);
            output[0] = Math.min(output[0], res[0]);
            output[1] = Math.max(output[1], res[1]);
        }
        if (node.left != null){
            int[] res = getRange(node.left, level - 1);
            output[0] = Math.min(output[0], res[0]);
            output[1] = Math.max(output[1], res[1]);
        }
        return output;
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        int[] minMax = getRange(root, 0);
        int range = minMax[1] - minMax[0] + 1;
        int current = -1 * minMax[0];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < range; i++){
            list.add(new ArrayList<>());
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        nodes.add(root);
        levels.add(current);

        while(!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            int level = levels.poll();
            list.get(level).add(node.val);
            if (node.left != null){
                nodes.add(node.left);
                levels.add(level - 1);
            }
            if (node.right != null){
                nodes.add(node.right);
                levels.add(level + 1);
            }
        }
        return list;
    }
}
