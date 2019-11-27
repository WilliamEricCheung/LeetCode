package tech.wec.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaxStack_716 {
    class MaxStack {
        private Stack<Integer> stack;
        private Stack<Integer> maxStack;
        /** initialize your data structure here. */
        public MaxStack() {
            stack = new Stack<>();
            maxStack = new Stack<>();
        }

        public void push(int x) {
            int max = maxStack.isEmpty()? x: maxStack.peek();
            maxStack.push(max > x? max : x);
            stack.push(x);
        }

        public int pop() {
            maxStack.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int max = peekMax();
            Stack<Integer> tmp = new Stack<>();
            while(top() != max) tmp.push(pop());
            pop();
            while(!tmp.isEmpty()) push(tmp.pop());
            return max;
        }
    }
}
