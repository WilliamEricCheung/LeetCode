package tech.wec.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves_1197 {
    class Solution {
        public int minKnightMoves(int x, int y) {
            int[][] directions = new int[][]{{2,1},{1,2},{-2,1},{-1,2},{2,-1},{1,-2},{-1,-2},{-2,-1}};
            boolean[][] visited = new boolean[620][620]; // 因为坐标可以为负，所以需要移动原点到[310,310]
            x += 310; y += 310;
            int result = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{310,310});
            visited[310][310] = true;
            while(!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++){
                    int[] cur = queue.remove();
                    if (cur[0] == x && cur[1] == y) return result;
                    for (int[] direction: directions){
                        int xx = cur[0] + direction[0];
                        int yy = cur[1] + direction[1];
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
