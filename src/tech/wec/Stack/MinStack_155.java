package tech.wec.Stack;

import java.util.Stack;

public class MinStack_155 {
    class MinStack {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (minStack.isEmpty() || x < minStack.peek())
                minStack.push(x);
            else
                minStack.push(minStack.peek());
            stack.push(x);
        }

        public void pop() {
            minStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
