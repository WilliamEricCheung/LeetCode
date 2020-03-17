package tech.wec.iLoveZQW;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze_490 {
    class Solution {
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            boolean[][] visited = new boolean[maze.length][maze[0].length];
            int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(start);
            visited[start[0]][start[1]] = true;
            while(!queue.isEmpty()){
                int[] loc = queue.remove();
                if (loc[0] == destination[0] && loc[1] == destination[1]) return true;
                for (int[] dir: directions){
                    int x = loc[0] + dir[0];
                    int y = loc[1] + dir[1];
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
