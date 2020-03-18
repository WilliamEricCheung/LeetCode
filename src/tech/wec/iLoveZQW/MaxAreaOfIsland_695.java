package tech.wec.iLoveZQW;

public class MaxAreaOfIsland_695 {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;
            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[0].length; j++){
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    int a = area(grid, i, j, visited);
                    if (a > max) max = a;
                }
            }
            return max;
        }

        private int area(int[][] grid, int x, int y, boolean[][] visited){
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y] && grid[x][y] == 1){
                visited[x][y] = true;
                return (1 + area(grid, x - 1, y, visited) + area(grid, x + 1, y, visited) +
                        area(grid, x, y - 1, visited) + area(grid, x, y + 1, visited));
            }else return 0;
        }
    }
}
