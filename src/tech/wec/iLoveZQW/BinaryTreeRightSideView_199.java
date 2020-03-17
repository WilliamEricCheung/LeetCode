package tech.wec.iLoveZQW;

import tech.wec.Tree.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView_199 {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            Map<Integer, Integer> rightMostAtDepth = new HashMap<>();
            int maxDepth = -1;
            Stack<Integer> depthStack = new Stack<>();
            Stack<TreeNode> nodeStack = new Stack<>();
            depthStack.push(0);
            nodeStack.push(root);
            while(!nodeStack.isEmpty()){
                TreeNode node = nodeStack.pop();
                Integer depth = depthStack.pop();
                if (node != null){
                    maxDepth = Math.max(maxDepth, depth);
                    if (!rightMostAtDepth.containsKey(depth))
                        rightMostAtDepth.put(depth, node.val);
                    nodeStack.push(node.left);
                    nodeStack.push(node.right);
                    depthStack.push(depth + 1);
                    depthStack.push(depth + 1);
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (int depth = 0; depth <= maxDepth; depth++){
                ans.add(rightMostAtDepth.get(depth));
            }
            return ans;
        }
    }
}
