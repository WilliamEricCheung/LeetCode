package tech.wec.Tree;

public class ConvertSortedArrayToBinarySearchTree_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return BST(nums, 0, nums.length-1);
    }

    private TreeNode BST(int[] nums, int start, int end){
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = BST(nums, start, mid-1);
        TreeNode right = BST(nums, mid+1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
