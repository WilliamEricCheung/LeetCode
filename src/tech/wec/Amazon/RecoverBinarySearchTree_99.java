package tech.wec.Amazon;

import tech.wec.Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RecoverBinarySearchTree_99 {
    class Solution_1 {
        /*
        1.Construct inorder traversal of the tree. It should be an almost sorted list where only two elements are swapped.
        2.Identify two swapped elements x and y in an almost sorted array in linear time.
        3.Traverse the tree again. Change value x to y and value y to x.
         */

        public void inorder(TreeNode root, List<Integer> nums){
            if (root == null) return;
            inorder(root.left, nums);
            nums.add(root.val);
            inorder(root.right, nums);
        }

        public int[] findTwoSwapped(List<Integer> nums){
            int n = nums.size();
            int x = -1, y = -1;
            for (int i = 0; i < n - 1; i++){
                if (nums.get(i + 1) < nums.get(i)){
                    y = nums.get(i + 1);
                    if (x == -1) x = nums.get(i);
                    else break;
                }
            }
            return new int[]{x, y};
        }

        public void recover(TreeNode root, int count, int x, int y){
            if (root != null){
                if (root.val == x || root.val == y){
                    root.val = root.val == x? y: x;
                    if (--count == 0) return;
                }
                recover(root.left, count, x, y);
                recover(root.right, count, x, y);
            }
        }

        public void recoverTree(TreeNode root) {
            List<Integer> nums = new ArrayList<>();
            inorder(root, nums);
            int[] swapped = findTwoSwapped(nums);
            recover(root, 2, swapped[0], swapped[1]);
        }
    }

    class Solution_2{

        public void swap(TreeNode a, TreeNode b){
            int tmp = a.val;
            a.val = b.val;
            b.val = tmp;
        }

        public void recoverTree(TreeNode root) {
            Deque<TreeNode> stack =  new ArrayDeque<>();
            TreeNode x = null, y = null, pred = null;
            while(!stack.isEmpty() || root != null){
                while(root != null){
                    stack.add(root); // add at first
                    root = root.left;
                }
                root = stack.removeLast();
                if (pred != null && root.val < pred.val){
                    y = root;
                    if (x == null) x = pred;
                    else break;
                }
                pred = root;
                root = root.right;
            }
            swap(x, y);
        }
    }
}
