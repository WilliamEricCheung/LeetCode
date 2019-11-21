package tech.wec.DepthFirstSearch;

import java.util.*;

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int maxDepth = -1;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);
        while(!nodeStack.isEmpty()){
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null){
                maxDepth = Math.max(maxDepth, depth);
                if (!rightmostValueAtDepth.containsKey(depth)){
                    rightmostValueAtDepth.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int depth = 0; depth<= maxDepth; depth++){
            result.add(rightmostValueAtDepth.get(depth));
        }
        return result;
    }
}
