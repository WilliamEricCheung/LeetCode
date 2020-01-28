package tech.wec.DynamicProgramming;

import java.util.Stack;

public class MinimumCostTreeFromLeafValues_1130 {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] maxx =  new int[n][n];
        for (int i = 0; i < n; i++) {
            maxx[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                maxx[i][j] = Math.max(arr[j], maxx[i][j - 1]);
            }
        }
        Integer[][] memo = new Integer[n][n];
        return helper(0, n - 1, arr, memo, maxx);
    }
    int helper(int start, int end, int[] arr, Integer[][] memo, int[][] maxx) {
        if (start >= end) {
            return 0;
        }
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            res = Math.min(res, maxx[start][i] * maxx[i + 1][end] + helper(start, i, arr, memo, maxx) + helper(i + 1, end, arr, memo, maxx));
        }
        memo[start][end] = res;
        return res;
    }

    class Solution_1 {
        // Use stack to keep a decreasing order, while there is bigger value arr[i],
        // then pop smaller value arr[i] and calculate the multiplication arr[i]*min(num, stack.peek()).
        public int mctFromLeafValues(int[] arr){
            if (arr == null || arr.length < 2) return 0;
            int ans = 0;
            Stack<Integer> stack = new Stack<>();
            for (int num: arr){
                while(!stack.isEmpty() && stack.peek() <= num){
                    int smaller = stack.pop();
                    if (stack.isEmpty()) ans += smaller * num;
                    else ans += smaller * Math.min(stack.peek(), num);
                }
                stack.push(num); // if num is smaller, push into stack
            }
            while(stack.size() > 1) ans += stack.pop() * stack.peek();
            return ans;
        }
    }
}
