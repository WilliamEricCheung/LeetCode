package tech.wec.Google;

public class BombEnemy_361 {
    public int maxKilledEnemies(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        int maxKilled = 0;
        int[][] killed = new int[m][n];

        for (int i = 0; i < m; i++){
            int enemy = 0;
            int leftWall = -1;
            int rightWall = -1;
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 'E') enemy++;
                else if (grid[i][j] == 'W') rightWall = j;
                if (grid[i][j] != 'W' && j == n - 1) rightWall = n;
                if (leftWall + 1 >= rightWall) continue;
                for (int k = leftWall + 1; k < rightWall; k++){
                    if (grid[i][k] != 'E' && grid[i][k] != 'W')
                        killed[i][k] += enemy;
                }
                leftWall = rightWall;
                enemy = 0;
            }
        }

        for (int j = 0; j < n; j++){
            int enemy = 0;
            int topWall = -1;
            int bottomWall = -1;
            for (int i = 0; i < m; i++){
                if (grid[i][j] == 'E') enemy++;
                else if (grid[i][j] == 'W') bottomWall = i;
                if (grid[i][j] != 'W' && i == m - 1) bottomWall = m;
                if (topWall + 1 >= bottomWall) continue;
                for (int k = topWall + 1; k < bottomWall; k++) {
                    if (grid[k][j] != 'E' && grid[k][j] != 'W') {
                        killed[k][j] += enemy;
                        maxKilled = Math.max(maxKilled, killed[k][j]);
                    }
                }
                topWall = bottomWall;
                enemy = 0;
            }
        }
        return maxKilled;
    }
}
