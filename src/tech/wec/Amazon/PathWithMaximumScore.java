package tech.wec.Amazon;

public class PathWithMaximumScore {

    // Define: dp[i][j] is the max score from [0][0] to [i][j]
    // Recurence Formula: dp[i][j] = max( min(dp[i-1][j], grid[i][j]), min(dp[i][j-1]), grid[i][j] )
    // Note: Init the first entry as Integer.MAX_VALUE
    public int getScore(int[][] matrix){
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = Integer.MAX_VALUE;
        for (int i = 1; i < rows; i++)
            dp[i][0] = Math.min(dp[i-1][0], matrix[i][0]);
        for (int j = 1; j<cols;j++)
            dp[0][j] = Math.min(dp[0][j-1], matrix[0][j]);
        for (int i = 1; i< rows; i++){
            for (int j = 1; j< cols;j++){
                if (i == rows - 1 && j == cols - 1)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                else{
                    int score1 = Math.min(dp[i-1][j], matrix[i][j]);
                    int score2 = Math.min(dp[i][j-1], matrix[i][j]);
                    dp[i][j] = Math.max(score1, score2);
                }
            }
        }
        return dp[rows-1][cols-1];
    }
}
