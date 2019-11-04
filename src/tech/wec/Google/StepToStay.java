package tech.wec.Google;

import java.util.Arrays;

public class StepToStay {
    int solve (int n, int h) {
        int[][] dp = new int[h][n+1];
        Arrays.fill(dp, 0);
        dp[0][n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int p = 0; p < h; p++) {
                dp[p][i] += dp[p][i + 1];
                if (p + 1 <  h) dp[p][i] += dp[p + 1][i + 1];
                if (p - 1 >= 0) dp[p][i] += dp[p - 1][i + 1];
            }
        }
        return dp[0][0];
    }
}
