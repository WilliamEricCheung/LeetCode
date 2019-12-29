package tech.wec.String;

public class OnesAndZeroes_474 {
    class Solution {
        // dp[i][j]=max(1+dp[i−zeroes_current_string][j−ones_current_string],dp[i][j])
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            for (String str: strs){
                int[] cnt = count(str);
                for (int zeroes = m; zeroes >= cnt[0]; zeroes--){
                    for (int ones = n; ones >= cnt[1]; ones--){
                        dp[zeroes][ones] = Math.max(1 + dp[zeroes - cnt[0]][ones - cnt[1]], dp[zeroes][ones]);
                    }
                }
            }
            return dp[m][n];
        }

        private int[] count(String s){
            int[] cnt = new int[2];
            for (int i = 0; i < s.length(); i++){
                cnt[s.charAt(i) - '0']++;
            }
            return cnt;
        }
    }
}
