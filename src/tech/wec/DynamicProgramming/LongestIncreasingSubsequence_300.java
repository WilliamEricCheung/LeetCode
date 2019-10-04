package tech.wec.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {
    // dp
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for(int i = 0; i < nums.length; i++){
            int cnt = 0;
            for (int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    cnt = Math.max(cnt, dp[j]);
            }
            dp[i] = cnt + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // dp with binary search
    public int lengthOfLIS_1(int[] nums){
        int[] dp = new int[nums.length];
        int len = 0;
        for(int num : nums){
            int i = Arrays.binarySearch(dp, 0, len, num);
            if( i < 0)
                i = -(i + 1);
            dp[i] = num;
            if(i == len)
                len++;
        }
        return len;
    }
}
