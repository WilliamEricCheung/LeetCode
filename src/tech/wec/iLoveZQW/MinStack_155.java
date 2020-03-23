package tech.wec.iLoveZQW;

import java.util.Stack;

public class MinStack_155 {
    class MinStack {

        /** initialize your data structure here. */
        private Stack<int[]> stack;
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()){
                stack.push(new int[]{x, x});
                return;
            }
            int min = stack.peek()[1];
            stack.push(new int[]{x, Math.min(x, min)});
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }
}
