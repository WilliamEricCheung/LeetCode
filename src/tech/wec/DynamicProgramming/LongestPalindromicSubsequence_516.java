package tech.wec.DynamicProgramming;

public class LongestPalindromicSubsequence_516 {
    // this problem can transform into longest common subsequence
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return LCS(s, t);
    }

    private int LCS(String s, String t){
        int m = s.length(), n = t.length();
        int[] dp = new int[n+1];
        for (int i = 1; i <= m; i++){
            int prev = 0;
            for (int j = 1; j <= n; j++){
                int temp = dp[j];
                dp[j] = s.charAt(i - 1) == t.charAt(j - 1)? prev + 1 : Math.max(dp[j], dp[j-1]);
                prev = temp;
            }
        }
        return dp[n];
    }
}
