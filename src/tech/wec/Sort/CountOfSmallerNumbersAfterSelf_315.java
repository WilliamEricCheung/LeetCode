package tech.wec.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf_315 {
    // 这是一个hard题，所以n^2的常规方法肯定不行
    class Solution {
        class TreeNode{
            public int val, count;

            public TreeNode(int val, int count) {
                this.val = val;
                this.count = count;
            }

            public TreeNode left = null, right = null;

        }
        public List<Integer> countSmaller(int[] nums) {
            int len = nums.length;
            if (len == 0) return new ArrayList<>();
            Integer[] res = new Integer[len];
            TreeNode root = new TreeNode(nums[len-1], 0);
            res[len - 1] = 0;
            for (int i = len - 2; i >= 0; i--){
                res[i] = insertNode(nums[i], root);
            }
            return Arrays.asList(res);
        }

        private int insertNode(int num, TreeNode root){
            int sum = 0;
            while(true){
                if (num < root.val){
                    root.count++;
                    if (root.left == null){
                        root.left = new TreeNode(num , 0);
                        break;
                    }
                    root = root.left;
                }else{
                    sum += root.count;
                    if (num != root.val) sum++;
                    if (root.right == null){
                        root.right = new TreeNode(num, 0);
                        break;
                    }
                    root = root.right;
                }
            }
            return sum;
        }
    }
}
