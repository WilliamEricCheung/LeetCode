package tech.wec.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        helper(root, stack, result);
        return result;
    }

    private void addPath(List<String> result, Stack<TreeNode> stack){
        StringBuilder sb = new StringBuilder();
        sb.append(stack.get(0).val);
        for (int i =1;i<=stack.size()-1;i++)
            sb.append("->"+stack.get(i).val);
        result.add(sb.toString());
    }

    private void helper(TreeNode root, Stack<TreeNode> stack, List<String> result){
        if (root == null)
            return;
        stack.add(root);
        if (root.left == null && root.right == null){
            addPath(result, stack);
            stack.pop();
            return;
        }
        helper(root.left, stack, result);
        helper(root.right, stack, result);
        stack.pop();
    }

    public List<String> binaryTreePaths_1(TreeNode root) {
        List<String> result = new ArrayList();
        Stack<TreeNode> stk = new Stack();
        while(!stk.isEmpty() || root != null) {
            while(root != null) {
                stk.push(root);
                root = root.left;
            }
            TreeNode popped=null;
            while(!stk.isEmpty() && stk.peek().right == popped) {
                if(stk.peek().left == null && stk.peek().right==null) {
                    addPath(result, stk);
                }
                popped = stk.pop();
            }
            if(!stk.isEmpty() && stk.peek().right != null){
                root = stk.peek().right;
            }
        }
        return result;
    }
}
