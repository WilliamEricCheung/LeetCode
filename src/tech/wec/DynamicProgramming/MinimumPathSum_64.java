package tech.wec.DynamicProgramming;

public class MinimumPathSum_64 {
    /**
     * path[i, j] = min(path[i-1. j], path[i, j-1]) + grid[i,j]
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] path = new int[height][width];
        path[0][0] = grid[0][0];
        for (int i =0;i<height;i++){
            for (int j =0;j<width;j++){
                if(i>0 && j>0)
                    path[i][j] = Math.min(path[i-1][j], path[i][j-1])+ grid[i][j];
                if(i==0 && j>0)
                    path[i][j]=  path[i][j-1] + grid[i][j];
                if(i>0  && j ==0)
                    path[i][j] = path[i-1][j] + grid[i][j];
            }
        }
        return path[height-1][width-1];
    }
}
