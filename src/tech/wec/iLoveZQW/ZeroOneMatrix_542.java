package tech.wec.iLoveZQW;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix_542 {
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int[][] ans = new int[matrix.length][matrix[0].length];
            Queue<int[]> queue = new LinkedList<>();
            int[][] directions = new int[][]{{0, 1},{0, -1},{1,0},{-1,0}};
            for (int i = 0; i < matrix.length; i++){
                for (int j = 0; j < matrix[0].length; j++){
                    if (matrix[i][j] == 0){
                        ans[i][j] = 0;
                        queue.offer(new int[]{i, j});
                    }
                    else{
                        ans[i][j] = Integer.MAX_VALUE;
                    }
                }
            }

            while(!queue.isEmpty()){
                int[] loc = queue.remove();
                for (int[] dir: directions){
                    int x = loc[0] + dir[0];
                    int y = loc[1] + dir[1];
                    if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length &&
                            ans[x][y] > ans[loc[0]][loc[1]] + 1){
                        ans[x][y] = ans[loc[0]][loc[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
            return ans;
        }
    }
}
