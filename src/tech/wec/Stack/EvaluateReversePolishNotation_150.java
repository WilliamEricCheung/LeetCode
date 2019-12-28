package tech.wec.Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation_150 {
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token: tokens){
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                    int op2 = stack.pop();
                    int op1 = stack.pop();
                    if (token.equals("+")) stack.push(op1 + op2);
                    if (token.equals("-")) stack.push(op1 - op2);
                    if (token.equals("*")) stack.push(op1 * op2);
                    if (token.equals("/")) stack.push(op1 / op2);
                }else stack.push(Integer.parseInt(token));
            }
            return stack.pop();
        }
    }
}
