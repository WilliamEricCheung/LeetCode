package tech.wec.Tree;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers_129 {
    class Solution {

        private List<String> list;

        public int sumNumbers(TreeNode root) {
            if (root == null) return 0;
             list = new ArrayList<>();
             StringBuilder temp = new StringBuilder();
             dfs(root, temp);
             int result = 0;
             for (String string: list){
                 result += Integer.parseInt(string);
             }
             return result;
        }

        private void dfs(TreeNode node, StringBuilder temp){
            if (node.left == null && node.right == null) {
                temp.append(node.val);
                list.add(temp.toString());
                //temp.delete(0, temp.length());
            }
            String tmp = temp.append(node.val).toString();
            if (node.left != null)dfs(node.left, new StringBuilder(tmp));
            if (node.right != null)dfs(node.right, new StringBuilder(tmp));
        }
    }
}
