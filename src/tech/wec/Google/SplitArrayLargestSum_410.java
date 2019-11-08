package tech.wec.Google;

import java.util.Arrays;
import java.util.regex.Matcher;

public class SplitArrayLargestSum_410 {
    // f[i][j]=max(f[k][j - 1], nums[k + 1] + ... + nums[i])
    public int splitArray_1(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        int[] sub = new int[n+1];
        for (int i = 0; i < n+1;i++)
            for (int j = 0; j < m+1; j++)
                dp[i][j] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            sub[i+1]= sub[i] + nums[i];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                for(int k = 0; k < i; k++){
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sub[i] - sub[k]));
                }
            }
        }
        return dp[n][m];
    }

    // Binary Search + Greedy
    public int splitArray(int[] nums, int m){
        long l = 0;
        long r = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++){
            r += nums[i];
            if (l < nums[i])
                l = nums[i];
        }
        long ans = r;
        while(l <= r){
            long mid = (l + r)>>1;
            long sum = 0;
            int cnt = 1; // count for sub-arrays
            for (int i = 0; i < n; i++){
                if (sum + nums[i] > mid){
                    cnt++;
                    sum = nums[i];
                }else
                    sum += nums[i];
            }
            if (cnt <= m){
                ans = Math.min(ans, mid);
                r = mid - 1;
            }else
                l = mid + 1;
        }
        return (int)ans;
    }
}
