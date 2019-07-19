package tech.wec.HashTable;

public class IslandPerimeter_463 {
    public int islandPerimeter(int[][] grid) {
        int cnt = 0;
        int col = grid.length;
        int row = grid[0].length;
        for (int i =0;i< col;i++){
            for (int j=0;j<row;j++){
                if (grid[i][j] == 0) continue; // water
                if (j==0|| grid[i][j-1] == 0) cnt++; // left is water
                if (i==0 || grid[i-1][j] == 0) cnt++; // top is water
                if (j==row-1 || grid[i][j+1] == 0) cnt++; // right is water
                if (i== col -1 || grid[i+1][j] == 0) cnt++; // button is water
            }
        }
        return cnt;
    }
}
