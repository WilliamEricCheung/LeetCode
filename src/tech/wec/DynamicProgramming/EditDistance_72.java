package tech.wec.DynamicProgramming;

public class EditDistance_72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i<=m; i++)
            dp[i][0] = i;
        for (int i = 0; i <= n; i++)
            dp[0][i] = i;
        for (int i =1;i<=m;i++){
            for (int j = 1;j <=n;j++){
                int left = dp[i-1][j];
                int down = dp[i][j-1];
                int leftDown = dp[i-1][j-1];
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = 1 + Math.min(left, Math.min(down, leftDown - 1));
                else
                    dp[i][j] = 1 + Math.min(left, Math.min(down, leftDown));
            }
        }
        return dp[m][n];
    }
}
