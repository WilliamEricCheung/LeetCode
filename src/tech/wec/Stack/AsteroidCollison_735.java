package tech.wec.Stack;

import java.util.Stack;

public class AsteroidCollison_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            stack.push(asteroids[i]);
            while (stack.size() >= 2 && stack.elementAt(stack.size() - 2) > 0 && stack.peek() < 0) {
                int top1 = stack.peek(), top2 = stack.elementAt(stack.size() - 2);
                if (-top1 > top2){
                    stack.pop(); stack.pop();
                    stack.push(top1);
                }else if (-top1 < top2){
                    stack.pop(); stack.pop();
                    stack.push(top2);
                }else{
                    stack.pop();stack.pop();
                }
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
