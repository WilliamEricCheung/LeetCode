package tech.wec.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix_1091 {
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
            int[][] directions = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[m][n];
            queue.add(new int[]{0,0});
            visited[0][0] = true;
            int minPath = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.remove();
                    if (cur[0] == m - 1 && cur[1] == n - 1) return minPath + 1;
                    for (int[] direction : directions) {
                        int x = cur[0] + direction[0];
                        int y = cur[1] + direction[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                            visited[x][y] = true;
                            queue.add(new int[]{x, y});
                        }
                    }
                }
                minPath++;
            }
            return -1;
        }
    }
}
