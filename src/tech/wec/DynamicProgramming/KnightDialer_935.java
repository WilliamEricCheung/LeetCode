package tech.wec.DynamicProgramming;

import java.util.Arrays;

public class KnightDialer_935 {
    int[][] paths = {{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
    final int MOD = 1_000_000_007;
    public int knightDialer(int N) {
        long[][] dp = new long[N+1][10];
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= N; i++){
            for (int j = 0; j < 10; j++){
                for (int p : paths[j]){
                    dp[i][j] = (dp[i][j] + dp[i-1][p]) % MOD;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < 10; i++){
            res = (res + dp[N][i]) % MOD;
        }
        return (int)res;
    }
}
