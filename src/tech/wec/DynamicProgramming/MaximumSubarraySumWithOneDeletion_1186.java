package tech.wec.DynamicProgramming;

public class MaximumSubarraySumWithOneDeletion_1186 {
    class Solution {
        //定义max0，表示以arr[i]结尾且一个都不漏的最大子数组和
        //定义max1，表示以arr[i]或者arr[i - 1]结尾，可以漏一个的最大子数组和
        //遍历数组，更新max1和max0（注意先更新max1，因为max1用到了上一个max0）
        //其中 max1 = max(max1 + arr[i], max0), 即删除arr[i - 1]或者删除arr[i]
        //其中 max0 = max(max0 + arr[i], arr[i])， 一个都不删除
        public int maximumSum(int[] arr) {
            int n = arr.length;
            if (n == 1) return arr[0];
            int max1 = arr[0];
            int max0 = arr[0];
            int result = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++){
                max1 = Math.max(max0, max1 + arr[i]);
                max0 = Math.max(arr[i], max0 + arr[i]);
                result = Math.max(result, Math.max(max1, max0));
            }
            return result;
        }
    }
}
