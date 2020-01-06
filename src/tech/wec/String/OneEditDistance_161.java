package tech.wec.String;

public class OneEditDistance_161 {
    class Solution {
        public boolean isOneEditDistance(String s, String t) {
            int d = minDistance(s, t);
            return d == 1;
        }

        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++)
                dp[i][0] = i;
            for (int i = 0; i <= n; i++)
                dp[0][i] = i;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int left = dp[i - 1][j];
                    int down = dp[i][j - 1];
                    int leftDown = dp[i - 1][j - 1];
                    if (word1.charAt(i - 1) == word2.charAt(j - 1))
                        dp[i][j] = 1 + Math.min(left, Math.min(down, leftDown - 1));
                    else
                        dp[i][j] = 1 + Math.min(left, Math.min(down, leftDown));
                }
            }
            return dp[m][n];
        }
    }

    class Solution_1 {
        public boolean isOneEditDistance(String s, String t){
            int ns = s.length();
            int nt = t.length();
            if (ns > nt) return isOneEditDistance(t, s);
            if (ns - nt > 1) return false;
            for (int i = 0; i < ns; i++){
                if (s.charAt(i) != t.charAt(i)){
                    if (ns == nt) return s.substring(i+1).equals(t.substring(i+1));
                    else return s.substring(i).equals(t.substring(i + 1));
                }
            }
            return (ns + 1 == nt);
        }
    }
}
