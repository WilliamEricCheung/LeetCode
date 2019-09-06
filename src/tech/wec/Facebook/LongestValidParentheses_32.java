package tech.wec.Facebook;

import java.util.Stack;

public class LongestValidParentheses_32 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i =0;i<s.length();i++){
            if (s.charAt(i) == '(')
                stack.push(i);
            else{
                stack.pop();
                if (stack.empty()){
                    stack.push(i);
                }else{
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }

    public int longestValidParenttheses_1(String s){
        int left = 0, right = 0;
        int max = 0;
        int len = s.length();
        for (int i =0;i<len;i++){
            if (s.charAt(i) == '(')
                left++;
            if (s.charAt(i) == ')')
                right++;
            if (left == right)
                max = Math.max(max, left * 2);
            if (right > left)
                left = right = 0;
        }
        left = right = 0;
        for (int i = len - 1; i >= 0; i--){
            if (s.charAt(i) == ')')
                right++;
            if (s.charAt(i) == '(')
                left++;
            if (left == right)
                max = Math.max(max, right * 2);
            if (left > right)
                left = right = 0;
        }
        return max;
    }
}
