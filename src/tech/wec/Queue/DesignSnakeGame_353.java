package tech.wec.Queue;

import java.util.*;

public class DesignSnakeGame_353 {
    class SnakeGame {

        private int[][] food;
        private Map<String, int[]> directions;
        private int width;
        private int height;
        private int foodIdx;
        Deque<int[]> snake;

        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            this.food = food;
            snake = new LinkedList<>();
            snake.addFirst(new int[]{0,0});
            directions = new HashMap<>();
            directions.put("U", new int[]{-1, 0});
            directions.put("L", new int[]{0, -1});
            directions.put("R", new int[]{0, 1});
            directions.put("D", new int[]{1, 0});
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            int[] dir = directions.get(direction);
            int[] head = snake.getFirst();
            int[] tail = snake.removeLast();
            int nextX = head[0] + dir[0];
            int nextY = head[1] + dir[1];
            if (nextX < 0 || nextX >= height || nextY < 0 || nextY >= width || isCollision(nextX, nextY)) return -1;
            snake.addFirst(new int[]{nextX, nextY});
            if (foodIdx < food.length && food[foodIdx][0] == nextX && food[foodIdx][1] == nextY){
                foodIdx++;
                snake.addLast(tail);
            }
            return snake.size() - 1;
        }

        private boolean isCollision(int i, int j){
            Iterator<int[]> iterator = snake.iterator();
            while (iterator.hasNext()){
                int[] pos = iterator.next();
                if (pos[0] == i && pos[1] == j) return true;
            }
            return false;
        }
    }
}
