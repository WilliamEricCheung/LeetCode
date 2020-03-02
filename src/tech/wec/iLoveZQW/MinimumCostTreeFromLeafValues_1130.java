package tech.wec.iLoveZQW;

import java.util.Stack;

public class MinimumCostTreeFromLeafValues_1130 {
    class Solution {
        public int mctFromLeafValues(int[] arr) {
            if (arr == null || arr.length < 2) return 0;
            Stack<Integer> stack = new Stack<>();
            int ans = 0;
            for (int num: arr){
                while(!stack.isEmpty() && stack.peek() < num){
                    int smaller = stack.pop();
                    if (stack.isEmpty()) ans += smaller * num;
                    else ans += smaller * Math.min(stack.peek(), num);
                }
                stack.push(num);
            }
            while(stack.size() > 1) ans += stack.pop() * stack.peek();
            return ans;
        }
    }
}
