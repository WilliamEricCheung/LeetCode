package tech.wec.Array;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class RottingOranges_994 {
    private int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    // bfs
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>(); // all starting cells with rotten oranges
        Map<Integer, Integer> depth = new HashMap<>();
        for (int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if (grid[r][c] == 2){
                    int code = r * cols + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()){
            int code = queue.remove();
            int r = code / cols, c = code % cols;
            for (int i = 0; i < 4; i++){
                int nr = r + direction[i][0];
                int nc = c + direction[i][1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc]== 1){
                    grid[nr][nc] = 2;
                    int nCode = nr * cols + nc;
                    queue.add(nCode);
                    depth.put(nCode, depth.get(code) + 1);
                    ans = depth.get(nCode);
                }
            }
        }
        for (int[] row: grid){
            for (int item: row){
                if (item == 1)
                    return -1;
            }
        }
        return ans;
    }
}
