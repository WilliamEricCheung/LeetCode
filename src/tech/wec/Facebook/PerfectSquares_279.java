package tech.wec.Facebook;

import java.util.Arrays;

public class PerfectSquares_279 {

    // 四平方和定理
    // https://www.cnblogs.com/grandyang/p/4800552.html
    public int numSquares(int n) {
        while( n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;
        for (int a = 0;a * a <= n; a++){
            int b = (int)Math.sqrt(n - a * a);
            if (a * a + b * b == n)
                return (a > 0 && b > 0)? 2 : 1;
        }
        return 3;
    }

    // dynamic programming
    public int numSquares_1(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i =0;i<=n;i++){
            for (int j =1;i + j*j <=n;j++){
                dp[i + j *j] = Math.min(dp[i+j *j], dp[i]+1);
            }
        }
        return dp[n];
    }
}
