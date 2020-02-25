package tech.wec.iLoveZQW;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class RottingOranges_994 {

    class Solution {
        public int orangesRotting(int[][] grid) {
            int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            int rows = grid.length, cols = grid[0].length;
            Queue<Integer> queue = new ArrayDeque<>();
            Map<Integer, Integer> depth = new HashMap<>(); // key for storing axis, value for the depth
            for (int i = 0; i < rows; i++){
                for (int j =0; j < cols; j++){
                    if (grid[i][j] == 2){
                        int code = i * cols + j;
                        queue.add(code);
                        depth.put(code, 0);
                    }
                }
            }
            int ans = 0;
            while(!queue.isEmpty()){
                int code = queue.remove();
                int r = code / cols, c = code % cols;
                for (int i = 0; i < 4; i++){
                    int nr = r + dirs[i][0];
                    int nc = c + dirs[i][1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        int newCode = nr * cols + nc;
                        queue.add(newCode);
                        depth.put(newCode, depth.get(code) + 1);
                        ans = depth.get(newCode);
                    }
                }
            }
            for (int[] Cols: grid){
                for (int item: Cols)
                    if (item == 1) return -1;
            }
            return ans;
        }
    }
}
