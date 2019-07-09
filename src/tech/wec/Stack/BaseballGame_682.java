package tech.wec.Stack;

import java.util.Stack;

public class BaseballGame_682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i =0;i<ops.length;i++){
            if (ops[i].equals("+")){
                int g1 = stack.pop();
                int g2 = g1 + stack.peek();
                stack.push(g1);
                stack.push(g2);
            }
            else if (ops[i].equals("D")){
                stack.push(stack.peek() * 2);
            }
            else if (ops[i].equals("C")){
                stack.pop();
            }
            else{
                stack.push(Integer.valueOf(ops[i]));
            }
        }
        while(!stack.empty()){
            sum += stack.pop();
        }
        return sum;
    }
}
