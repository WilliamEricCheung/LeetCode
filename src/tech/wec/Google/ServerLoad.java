package tech.wec.Google;

import java.util.Arrays;

public class ServerLoad {
    static int solution(Integer[] loads) {
        int sum = 0;
        for (Integer load : loads)
            sum += load;
        Integer[][] dp = new Integer[loads.length + 1][sum + 1];
        // fill base case
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < loads.length + 1; i++)
            dp[i][0] = 1;
        for (int i = 1;i < loads.length + 1; i++){
            for (int j = 1; j < sum + 1; j++){
                dp[i][j] = dp[i-1][j];
                if (j >= loads[i-1])
                    dp[i][j] |= dp[i-1][j - loads[i-1]];
            }
        }
        int diff = 0;
        for (int i = sum / 2; i >= 0; i--){
            if (dp[loads.length][i] == 1){
                diff = (sum - 2 * i);
                break;
            }
        }
        return diff;
    }
}
