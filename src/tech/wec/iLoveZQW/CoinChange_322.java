package tech.wec.iLoveZQW;

import java.util.Arrays;

public class CoinChange_322 {
    class Solution {
        // dynamic programming
        // [1,2,5] - 11
        // f(11) = min(f(11-1), f(11-2), f(11-5)) + 1
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++){
                for (int j = 0; j < coins.length; j++){
                    if (i - coins[j] >= 0)
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
            return dp[amount] <= amount? dp[amount]: -1;
        }
    }
}
