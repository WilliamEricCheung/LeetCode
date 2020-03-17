package tech.wec.iLoveZQW;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumKnightMoves_1197 {
    class Solution {
        public int minKnightMoves(int x, int y) {
            // use bfs to solve this problem
            int[][] directions = new int[][]{{2, 1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2},{-2,-1},{-2,1}};
            boolean[][] visited = new boolean[620][620];
            x += 310; y += 310; // move the center to 310, 310
            int result = 0;
            Queue<int[]> queue = new LinkedList<>(); // int[] store the location info
            queue.add(new int[]{310, 310});
            visited[310][310] = true;
            while(!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] loc = queue.remove();
                    if (x == loc[0] && y == loc[1]) return result;
                    for (int[] dir: directions){
                        int xx = loc[0] + dir[0];
                        int yy = loc[1] + dir[1];
                        if (!visited[xx][yy]){
                            queue.add(new int[]{xx, yy});
                            visited[xx][yy] = true;
                        }
                    }
                }
                result++;
            }
            return 0;
        }
    }
}
