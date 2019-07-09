package tech.wec.Tree;

public class PathSumIII_437 {
    private int cnt = 0;
    public int pathSum(TreeNode root, int sum) {
        while(root != null){
            DFS(root, sum, 0);
            pathSum(root.left, sum);
            pathSum(root.right, sum);
        }
        return cnt;
    }
    public void DFS(TreeNode root, int target, int sum){
        if (root == null) return;
        sum += root.val;
        if (sum == target)
            cnt++;
        DFS(root.left, target, sum);
        DFS(root.right, target, sum);
    }
}
