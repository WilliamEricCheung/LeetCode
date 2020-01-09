package tech.wec.DepthFirstSearch;

import tech.wec.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree_863 {
    class Solution {
        private TreeNode target;
        private int K;
        private List<Integer> result;
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            this.target = target;
            this.K = K;
            this.result = new ArrayList<>();
            dfs(root);
            return result;
        }

        private int dfs(TreeNode node){
            if (node == null) return -1;
            else if (node == target){ // 不横跨父节点
                addSubtree(node, 0);
                return 1;
            }else{ // 横跨父节点
                int L = dfs(node.left), R = dfs(node.right);
                if (L != -1){
                    if (L == K) result.add(node.val);
                    addSubtree(node.right, L + 1);
                    return L + 1;
                }else if (R != -1){
                    if (R == K) result.add(node.val);
                    addSubtree(node.left, R + 1);
                    return R + 1;
                }else return -1;
            }
        }

        private void addSubtree(TreeNode node, int dist){
            if (node == null) return;
            if (dist == K) result.add(node.val);
            else{
                addSubtree(node.left, dist + 1);
                addSubtree(node.right, dist + 1);
            }
        }
    }
}
