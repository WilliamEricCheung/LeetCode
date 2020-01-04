package tech.wec.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings_317 {
    class Solution {

        private int[][] reachable;
        private int[][] totalDistance;
        private int min;
        private int count;

        public int shortestDistance(int[][] grid) {
            reachable = new int[grid.length][grid[0].length];
            totalDistance = new int[grid.length][grid[0].length];
            min = Integer.MAX_VALUE;
            count = 0;
            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[0].length; j++){
                    if (grid[i][j] == 1){
                        bfs(grid, i, j);
                        count++;
                    }
                }
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (reachable[i][j] == count && grid[i][j] == 0)
                        min = Math.min(min, totalDistance[i][j]);
                }
            }
            return min == Integer.MAX_VALUE? -1: min;
        }

        private void bfs(int[][] grid, int i, int j){
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            queue.add(new int[]{i, j});
            visited[i][j] = true;
            int dist = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                dist++;
                for (int k = 0; k < size; k++){
                    int[] pos = queue.poll();
                    int x = pos[0];
                    int y = pos[1];
                    if (x > 0 && !visited[x-1][y] && grid[x-1][y] == 0){
                        queue.add(new int[]{x-1, y});
                        reachable[x-1][y]++;
                        totalDistance[x-1][y] += dist;
                        visited[x-1][y] = true;
                    }
                    if (x < grid.length - 1 && !visited[x+1][y] && grid[x+1][y] == 0){
                        queue.add(new int[]{x+1, y});
                        reachable[x+1][y]++;
                        totalDistance[x+1][y] += dist;
                        visited[x+1][y] = true;
                    }
                    if (y > 0 && !visited[x][y-1] && grid[x][y-1] == 0){
                        queue.add(new int[]{x, y-1});
                        reachable[x][y-1]++;
                        totalDistance[x][y-1] += dist;
                        visited[x][y-1] = true;
                    }
                    if (y < grid[0].length - 1 && !visited[x][y+1] && grid[x][y+1] == 0){
                        queue.add(new int[]{x, y+1});
                        reachable[x][y+1]++;
                        totalDistance[x][y+1] += dist;
                        visited[x][y+1] = true;
                    }
                }
            }
        }
    }
}
