package tech.wec.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze_490 {
    // dfs
    class Solution_1 {
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            boolean[][] visited = new boolean[maze.length][maze[0].length];
            return dfs(maze, start, destination, visited);
        }

        private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited){
            if (visited[start[0]][start[1]]) return false;
            if (start[0] == destination[0] && start[1] == destination[1]) return true;
            visited[start[0]][start[1]] = true;
            int right = start[1] + 1, left = start[1] - 1, up = start[0] -1, down = start[0] + 1;
            // go rightmost
            while(right < maze[0].length && maze[start[0]][right] == 0)
                right++;
            if (dfs(maze, new int[]{start[0], right - 1}, destination, visited)) return true;
            // go leftmost
            while(left >= 0 && maze[start[0]][left] == 0)
                left--;
            if (dfs(maze, new int[]{start[0], left + 1}, destination, visited)) return true;
            // go rightmost
            while(up >= 0 && maze[up][start[1]] == 0)
                up--;
            if (dfs(maze, new int[]{up + 1, start[1]}, destination, visited)) return true;
            // go rightmost
            while(down < maze.length && maze[down][start[1]] == 0)
                down++;
            if (dfs(maze, new int[]{down - 1, start[1]}, destination, visited)) return true;
            return false;
        }
    }

    // bfs
    class Solution_2{
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            boolean[][] visited = new boolean[maze.length][maze[0].length];
            int[][] directions = new int[][]{{0, 1},{0, -1},{1,0},{-1,0}};
            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            visited[start[0]][start[1]] = true;
            while(!queue.isEmpty()){
                int[] cur = queue.remove();
                if (cur[0] == destination[0] && cur[1] == destination[1]) return true;
                for (int[] dir: directions){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    while(x>=0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0){
                        x += dir[0];
                        y += dir[1];
                    }
                    if (!visited[x - dir[0]][y - dir[1]]){
                        queue.add(new int[]{x - dir[0], y - dir[1]});
                        visited[x - dir[0]][y - dir[1]] = true;
                    }
                }
            }
            return false;
        }
    }
}
