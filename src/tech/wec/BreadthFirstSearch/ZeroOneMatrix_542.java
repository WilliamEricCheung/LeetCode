package tech.wec.BreadthFirstSearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix_542 {
    class Solution {
        // bfs
        public int[][] updateMatrix(int[][] matrix) {
            int[][] result = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            int[][] directions = new int[][]{{0, 1},{0, -1},{1,0},{-1,0}};
            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix[0].length; j++){
                    if (matrix[i][j] == 0){
                        result[i][j] = 0;
                        queue.add(new int[]{i, j});
                    }
                }
            }
            while(!queue.isEmpty()){
                int[] cur = queue.remove();
                for (int[] dir: directions){
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length &&
                        result[x][y] > result[cur[0]][cur[1]] + 1){
                        result[x][y] = result[cur[0]][cur[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            return result;
        }
    }
}
