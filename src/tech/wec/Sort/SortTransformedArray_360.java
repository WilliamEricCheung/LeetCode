package tech.wec.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTransformedArray_360 {
    class Solution {
        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            List<Integer> list = new ArrayList<>();
            if (a == 0){
                if (b < 0){
                    for (int num: nums)
                        list.add(0, (int)func(a,b,c,num));
                }
                else{
                    for (int num: nums)
                        list.add((int) func(a,b,c,num));
                }
                return list.stream().mapToInt(i -> i).toArray();
            }
            // double axis = - b / (2.0 * a);
            boolean up = a > 0;
            // 这里使用双指针类似于合并两排好序的链表
            int[] result = new int[nums.length];
            Arrays.fill(result, 0);
            int left = 0, right = nums.length - 1;
            int idx = up? nums.length - 1: 0;
            while(left < right){
                int vleft = (int)func(a,b,c,nums[left]);
                int vright = (int)func(a,b,c,nums[right]);
                if (up){
                    // 在axis前的是递减
                    if (vleft >= vright){
                        result[idx--] = vleft;
                        left++;
                    }else{
                        result[idx--] = vright;
                        right--;
                    }
                }else{
                    if (vleft >= vright){
                        result[idx++] = vright;
                        right--;
                    }else{
                        result[idx++] = vleft;
                        left++;
                    }
                }
            }
            result[idx] = (int) func(a,b,c, nums[left]);
            return result;
        }

        private long func(int a, int b, int c, int n){
            return a * n * n + b * n + c;
        }
    }
}
