package tech.wec.DepthFirstSearch;

public class MaxAreaOfIsland_695 {
    class Solution {

        public int maxAreaOfIsland(int[][] grid) {
            boolean[][] visited = new boolean[grid.length][grid[0].length];
            int result = 0;
            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[0].length; j++)
                    result = Math.max(result, area(grid, i, j, visited));
            }
            return result;
        }

        // dfs
        private int area(int[][] grid, int i, int j, boolean[][] visited){
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) return 0;
            visited[i][j] = true;
            return (1 + area(grid, i + 1, j, visited) + area(grid,i - 1 , j, visited)
                    + area(grid, i, j + 1, visited) + area(grid,i, j - 1, visited));
        }
    }
}
